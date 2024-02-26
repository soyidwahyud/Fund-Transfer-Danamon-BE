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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CustController {
    @Autowired
    CustService custService;

    @PostMapping("/add-cust")
    public CustResponse registerCust(HttpServletRequest requestServlet, HttpServletResponse response, @Validated @RequestBody CustRequest custRequest, CustResponse custResponse){
        return custService.registerCust(requestServlet,response,custRequest,custResponse);
    }
    @PostMapping("/get-data-cust")
    public List<CustGetDataResponse> dataResponse(HttpServletRequest requestServlet, HttpServletResponse response, @RequestParam(value = "username") String username){
        return custService.dataResponse(requestServlet,response,username);
    }
}
