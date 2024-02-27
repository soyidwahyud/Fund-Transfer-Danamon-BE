package com.danamon.fundtransfer.fundtransferdanamonbe.mapper.impl;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.FundTransferRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.FundTransferResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.FundTransfer;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.FundTransfer.FundTransferBuilder;
import com.danamon.fundtransfer.fundtransferdanamonbe.mapper.FundTransferMapper;
import com.danamon.fundtransfer.fundtransferdanamonbe.repository.AcctRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class FundTransferMapperImpl implements FundTransferMapper {

    @Autowired
    private AcctRepository repository;

    @Override
    public FundTransfer requestFundTransfer(FundTransferRequest request) {
        if(request == null){
            return null;
        }
        String dataAcct = repository.findSenderByNoAcct(request.getAcctSender());
        if(dataAcct == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not Found");
        }
        Optional<Acct> acctSender = repository.findAcctSenderByNoAcct(request.getAcctSender());
        if (acctSender.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not Found");
        }
        BigDecimal countBalance = repository.findBalanceByNoAcct(request.getAcctSender());
        if(countBalance.toString().length() < request.getTransfer().toString().length()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The balance is not sufficient");
        }
        FundTransferBuilder builder = FundTransfer.builder();
        builder.acctSender(request.getAcctSender());
        builder.senderName(request.getSenderName());
        builder.acctReceiver(request.getAcctReceiver());
        builder.receiverName(request.getReceiverName());
        if (request.getAcctReceiver().length() != 8 && request.getTransactionType() == 2){
            if (request.getTransfer().toString().length() == 5){
                builder.transfer(request.getTransfer());
                builder.adminFee(BigDecimal.valueOf(6500));
                builder.total(request.getTransfer().add(BigDecimal.valueOf(6500)));
                acctSender.get().setBalance(acctSender.get().getBalance().subtract(request.getTransfer().add(BigDecimal.valueOf(6500))));
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Limit Transfer more than 10000");
        } else if (request.getAcctReceiver().length() == 8) {
            String dataReceiver = repository.findSenderByNoAcct(request.getAcctReceiver());
            if(dataReceiver == null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not Found");
            }
            Optional<Acct> acctReceiver = repository.findReceiverByNoAcct(request.getAcctReceiver());
            if (acctReceiver.isEmpty()){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Data Not Found");
            }
            builder.transfer(request.getTransfer());
            builder.adminFee(BigDecimal.valueOf(0));
            builder.total(request.getTransfer().add(BigDecimal.valueOf(0)));
            acctSender.get().setBalance(acctSender.get().getBalance().subtract(request.getTransfer().add(BigDecimal.valueOf(0))));
            acctReceiver.get().setBalance(acctReceiver.get().getBalance().add(request.getTransfer().add(BigDecimal.valueOf(0))));
        }
        builder.reason(request.getReason());
        builder.status(request.getStatus());
        builder.transactionType(request.getTransactionType());
        return builder.build();
    }

    @Override
    public FundTransferResponse responseFundTransfer(FundTransfer fundTransfer) {
        FundTransferResponse response = new FundTransferResponse();
        response.setId(fundTransfer.getId());
        response.setAcctSender(fundTransfer.getAcctSender());
        response.setSenderName(fundTransfer.getSenderName());
        response.setAcctReceiver(fundTransfer.getAcctReceiver());
        response.setReceiverName(fundTransfer.getReceiverName());
        response.setTransfer(fundTransfer.getTransfer());
        if (response.getAcctReceiver().length() != 8){
            response.setAdminFee(BigDecimal.valueOf(6500));
            response.setTotal(fundTransfer.getTotal());
        } else if (response.getAcctReceiver().length() == 8) {
            response.setAdminFee(BigDecimal.valueOf(0));
            response.setTotal(fundTransfer.getTotal());
        }
        response.setReason(fundTransfer.getReason());
        response.setStatus(fundTransfer.getStatus());
        response.setTransactionType(fundTransfer.getTransactionType());
        return response;
    }
}
