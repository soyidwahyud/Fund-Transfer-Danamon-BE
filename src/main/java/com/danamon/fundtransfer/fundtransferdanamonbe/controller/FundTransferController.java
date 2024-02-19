package com.danamon.fundtransfer.fundtransferdanamonbe.controller;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.FundTransferRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.FundTransferResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.FundTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FundTransferController {
    @Autowired
    private FundTransferService service;

    @PostMapping("/fund-transfer")
    public FundTransferResponse requestFundTransfer(@Validated @RequestBody FundTransferRequest request){
        return service.requestFundTransfer(request);
    }
    @PostMapping("/get-data-fund-transfer")
    public List<FundTransferResponse> findAll(){
        return service.findAll();
    }
}
