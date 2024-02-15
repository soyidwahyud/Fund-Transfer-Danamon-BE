package com.danamon.fundtransfer.fundtransferdanamonbe.service.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.SignInRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.JwTResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.LoginResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.MessageResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.CustMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.CustRepository;
import com.danamon.fundtransfer.fundtransferdanamonbe.security.jwt.JwtGenerator;
import com.danamon.fundtransfer.fundtransferdanamonbe.security.jwt.JwtUtils;
import com.danamon.fundtransfer.fundtransferdanamonbe.security.service.UserDetailsImpl;
import com.danamon.fundtransfer.fundtransferdanamonbe.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustServiceImpl implements CustService{
    @Autowired
    private CustRepository custRepository;

    @Autowired
    CustMapper custMapper;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    JwtGenerator jwtGenerator;

    @Value("${danamon.app.jwt-cookie-name}")
    private String cookieName;



    @Override
    public ResponseEntity<?> registerCust(CustRequest request) {
        if(custRepository.existsByUsername(request.getUsername())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username already taken!!"));
        }

        String encodedPassword = encoder.encode(request.getPasswd());
        var cust = custMapper.requestCust(request);
        cust.setPasswd(encodedPassword);
        var result = custRepository.save(cust);
        System.out.println(result);
        return ResponseEntity.ok(new MessageResponse("Register Successfully!!"));
    }

    @Override
    public List<Object> isCustPresent(Cust cust) {
        boolean custExist = false;
        String message = null;
        Optional<Cust> existingUsername = custRepository.findByUsername(cust.getUsername());
        if (existingUsername.isPresent()){
            custExist = true;
            message = "Username Already present";
        }
        return Arrays.asList(custExist, message);
    }

    @Override
    public ResponseEntity<?> signOutCust() {
        ResponseCookie resCookie = ResponseCookie.from(cookieName, null)
                .httpOnly(true)
                .secure(true)
                .path("/api")
                .maxAge(0)
//                .domain("localhost")
                .build();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, resCookie.toString()).build();
    }

    @Override
    public ResponseEntity<LoginResponse> authenticateUser(SignInRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPasswd()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication,"Cust");
        LoginResponse response = new LoginResponse();
        response.setSuccess(true);
        response.setMessage("Login Successful");
        response.setToken(token);
        Cust cust = custRepository.findByUsername(request.getUsername()).orElseThrow();
        response.setCustDetails(cust.getUsername(),cust.getId());
        return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
    }

}
