package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.IntegrationLog;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.CustMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.*;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.CustService;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

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
    private IntegrationLogRepository integrationLogRepository;

    @Autowired
    CustMapper custMapper;


    @Value("${danamon.app.jwt-cookie-name}")
    private String cookieName;



    @Override
    public CustResponse registerCust(HttpServletRequest requestServlet, HttpServletResponse response, CustRequest request,CustResponse custResponse) {

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

        integrationLogRepository.save(
                IntegrationLog.builder()
                        .correlationId(UUID.randomUUID().toString())
                        .activity(Thread.currentThread().getStackTrace()[1].getMethodName())
                        .connectString(requestServlet.getRequestURL().toString())
                        .createdBy(request.getUsername())
                        .createdTime(new Date(new Date().getTime() + (7 * 60 * 60 * 1000)))
                        .requestJson(request.toString())
                        .responseJson(custMapper.responseCust(result,resultCustProfile).toString())
                        .requestMethod(requestServlet.getMethod())
                        .responseTime(System.currentTimeMillis())
                        .statusCode(response.getStatus())
                        .build()
        );

        return custMapper.responseCust(result, resultCustProfile);
    }

    @Override
    public CustGetDataResponse dataResponse(HttpServletRequest requestServlet, HttpServletResponse response,String username, Cust cust, Acct acct, CustProfile custProfile) {
//        Optional<Cust> dataCust = custRepository.findByUsername(username);
//        if (dataCust.isEmpty()) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, "Data Not Found");
//        }
//        integrationLogRepository.save(
//                IntegrationLog.builder()
//                        .activity(Thread.currentThread().getStackTrace()[1].getMethodName())
//                        .connectString(requestServlet.getRequestURL().toString())
//                        .createdBy(request.getUsername())
//                        .createdTime(new Date(new Date().getTime() + (7 * 60 * 60 * 1000)))
//                        .requestJson(request.toString())
//                        .responseJson(custResponse.toString())
//                        .requestMethod(requestServlet.getMethod())
//                        .responseTime(System.currentTimeMillis())
//                        .statusCode(response.getStatus())
//                        .build()
//        );
        return custMapper.responseGetDataCust(username, cust,acct,custProfile);
    }
}
