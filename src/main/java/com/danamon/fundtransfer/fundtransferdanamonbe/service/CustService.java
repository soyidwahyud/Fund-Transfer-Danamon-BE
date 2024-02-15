package com.danamon.fundtransfer.fundtransferdanamonbe.service;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.SignInRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustService {
    ResponseEntity<?> registerCust(CustRequest request);
    public List<Object> isCustPresent(Cust cust);
    ResponseEntity<?> signOutCust();
    ResponseEntity<?> authenticateUser(SignInRequest request);
}
