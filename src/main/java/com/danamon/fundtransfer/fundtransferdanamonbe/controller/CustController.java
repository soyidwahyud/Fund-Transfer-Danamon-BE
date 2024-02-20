package com.danamon.fundtransfer.fundtransferdanamonbe.controller;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.SignInRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;
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

    @PostMapping("/add-cust")
    public CustResponse registerCust(@Validated @RequestBody CustRequest custRequest){
        return custService.registerCust(custRequest);
    }
    @PostMapping("/get-data-cust")
    public CustGetDataResponse dataResponse(@RequestParam(value = "username") String username){
        Cust cust = new Cust();
        return custService.dataResponse(username,cust);
    }
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
