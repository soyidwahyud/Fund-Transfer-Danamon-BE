package com.danamon.fundtransfer.fundtransferdanamonbe.mapper.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustProfileRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustProfileResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust.CustBuilder;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile.CustProfileBuilder;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.CustMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustProfileRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Component
public class CustMapperImpl implements CustMapper {

    @Autowired
    private CustProfileRepository custProfileRepository;

    @Autowired
    private CustRepository custRepository;

    @Override
    public Cust requestCust(CustRequest request) {
        if(request == null){
            return null;
        }
        CustBuilder custBuilder = Cust.builder();
        CustProfileBuilder custProfileBuilder = CustProfile.builder();

        custBuilder.username(request.getUsername());
        custBuilder.passwd(request.getPasswd());
        if (request.getAtmCifNo() != null){
            custBuilder.atmCifNo("00" + request.getAtmCifNo());
            custBuilder.registrationType(1);
        } else if (request.getVisaMasterCifNo() != null) {
            custBuilder.atmCifNo(request.getVisaMasterCifNo());
            custBuilder.registrationType(2);
        }
        custBuilder.registrationType(request.getRegistrationType());
        custBuilder.status(request.getStatus());
        return custBuilder.build();
    }

    @Override
    public CustProfile requestCustProfile(CustProfileRequest request) {
        if(request == null){
            return null;
        }
        Cust cust = custRepository.findIdByUsername(request.getUsername());
        CustProfileBuilder custProfileBuilder = CustProfile.builder();
//        custProfileBuilder.cust(cust);
        custProfileBuilder.username(request.getUsername());
        custProfileBuilder.email(request.getEmail());
        custProfileBuilder.fullname(request.getFullname());
        custProfileBuilder.shortName(request.getShortName());
        custProfileBuilder.mobile_no(request.getMobileNo());
        custProfileBuilder.status(request.getStatus());
        return custProfileBuilder.build();
    }

    @Override
    public CustResponse responseCust(Cust cust, CustProfile custProfile) {
        CustResponse response = new CustResponse();
        response.setId(cust.getId());
        response.setUsername(cust.getUsername());
        response.setPasswd(cust.getPasswd());
        response.setAtmCifNo(cust.getAtmCifNo());
        response.setVisaMasterCifNo(cust.getVisaMasterCifNo());
        response.setRegistrationType(cust.getRegistrationType());
        response.setStatus(cust.getStatus());

        CustProfileResponse custProfileResponse = new CustProfileResponse();
        custProfileResponse.setCustId(cust.getId());
        custProfileResponse.setUsername(custProfile.getUsername());
        custProfileResponse.setEmail(custProfile.getEmail());
        custProfileResponse.setFullName(custProfile.getFullname());
        custProfileResponse.setShortName(custProfile.getShortName());
        custProfileResponse.setMobileNo(custProfile.getMobile_no());
        custProfileResponse.setStatus(custProfile.getStatus());
        response.setCustProfileResponse(custProfileResponse);
        return response;
    }
}
