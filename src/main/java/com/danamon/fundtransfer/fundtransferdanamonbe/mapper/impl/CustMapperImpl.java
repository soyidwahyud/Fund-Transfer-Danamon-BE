package com.danamon.fundtransfer.fundtransferdanamonbe.mapper.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust.CustBuilder;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.CustMapper;
import org.springframework.stereotype.Component;

@Component
public class CustMapperImpl implements CustMapper {
    @Override
    public Cust requestCust(CustRequest request) {
        if(request == null){
            return null;
        }
        CustBuilder custBuilder = Cust.builder();
        custBuilder.username(request.getUsername());
        custBuilder.passwd(request.getPasswd());
//        custBuilder.atmCifNo(request.getAtmCifNo());
//        custBuilder.visaMasterCifNo(request.getVisaMasterCifNo());
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
    public CustResponse responseCust(Cust cust) {
        CustResponse response = new CustResponse();
        response.setId(cust.getId());
        response.setUsername(cust.getUsername());
        response.setPasswd(cust.getPasswd());
        response.setAtmCifNo(cust.getAtmCifNo());
        response.setVisaMasterCifNo(cust.getVisaMasterCifNo());
        response.setRegistrationType(cust.getRegistrationType());
        response.setStatus(cust.getStatus());
        return response;
    }
}
