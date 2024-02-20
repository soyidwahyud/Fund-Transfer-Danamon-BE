package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.CustMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.AcctRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustProfileRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustRelRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.CustService;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@Transactional
public class CustServiceImpl implements CustService{
    @Autowired
    private CustRepository custRepository;

    @Autowired
    private CustProfileRepository custProfileRepository;

    @Autowired
    private AcctRepository acctRepository;

    @Autowired
    private CustRelRepository custRelRepository;

    @Autowired
    CustMapper custMapper;


    @Value("${danamon.app.jwt-cookie-name}")
    private String cookieName;



    @Override
    public CustResponse registerCust(CustRequest request) {

        String hashed = Hashing.sha256()
                .hashString(request.getPasswd(), StandardCharsets.UTF_8)
                .toString();
        var cust = custMapper.requestCust(request);
        var custProfile = custMapper.requestCustProfile(request.getCustProfileRequest());
        var acct = custMapper.requestAcct();

        cust.setPasswd(hashed);
        cust.setCustProfile(custProfile);
        custProfile.setCust(cust);
        acct.setStatus(138);
        acct.setBalance(BigDecimal.valueOf(0));
        if(cust.getAtmCifNo()!= null){
            cust.setRegistrationType(1);
        } else if (cust.getVisaMasterCifNo() != null) {
            cust.setRegistrationType(2);
        }
        var result = custRepository.save(cust);
        var resultCustProfile = custProfileRepository.save(custProfile);
        var custRel = custMapper.requestCustRel(result,acct);
        custProfileRepository.save(custProfile);
        acctRepository.save(acct);
        custRelRepository.save(custRel);

        return custMapper.responseCust(result, resultCustProfile);
    }

    @Override
    public CustGetDataResponse dataResponse(String username, Cust cust) {
//        Optional<Cust> dataCust = custRepository.findByUsername(username);
//        if (dataCust.isEmpty()) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Data Not Found");
//        }
        return custMapper.responseGetDataCust(username, cust);
    }
}
