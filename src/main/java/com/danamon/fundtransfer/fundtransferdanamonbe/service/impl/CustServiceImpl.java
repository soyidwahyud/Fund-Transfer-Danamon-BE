package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.CustMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustProfileRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.CustService;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

@Service
@Transactional
public class CustServiceImpl implements CustService{
    @Autowired
    private CustRepository custRepository;

    @Autowired
    private CustProfileRepository custProfileRepository;

    @Autowired
    CustMapper custMapper;


    @Value("${danamon.app.jwt-cookie-name}")
    private String cookieName;



    @Override
    public CustResponse registerCust(CustRequest request) {
        Cust dataUsername = custRepository.findIdByUsername(request.getUsername());

        String hashed = Hashing.sha256()
                .hashString(request.getPasswd(), StandardCharsets.UTF_8)
                .toString();
        var cust = custMapper.requestCust(request);
        var custProfile = custMapper.requestCustProfile(request.getCustProfileRequest());
        cust.setPasswd(hashed);
        cust.setCustProfile(custProfile);
        custProfile.setCust(cust);
        if(cust.getAtmCifNo()!= null){
            cust.setRegistrationType(1);
        } else if (cust.getVisaMasterCifNo() != null) {
            cust.setRegistrationType(2);
        }
        var result = custRepository.save(cust);
        var resultCustProfile = custProfileRepository.save(custProfile);
        custProfileRepository.save(custProfile);

        return custMapper.responseCust(result, resultCustProfile);
    }

}
