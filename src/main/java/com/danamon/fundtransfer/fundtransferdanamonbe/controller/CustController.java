package com.danamon.fundtransfer.fundtransferdanamonbe.controller;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.SignInRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustController {
    @Autowired
    CustService custService;

    @PostMapping("/auth/signup")
    public ResponseEntity<?> registerCust(@Validated @RequestBody CustRequest custRequest){
        return custService.registerCust(custRequest);
    }
    @PostMapping("/auth/signin")
    public ResponseEntity<?> authenticateUser(@Validated @RequestBody SignInRequest request) {
        return custService.authenticateUser(request);
    }
    @PostMapping("/auth/signout")
    public ResponseEntity<?> signOutUser(){
        return custService.signOutCust();
    }
}
