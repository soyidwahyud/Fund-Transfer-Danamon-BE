package com.danamon.fundtransfer.fundtransferdanamonbe.service;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.FundTransferRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.FundTransferResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.FundTransfer;

import java.util.List;

public interface FundTransferService {
    FundTransferResponse requestFundTransfer(FundTransferRequest request);
    List<FundTransferResponse> findAll();
}
