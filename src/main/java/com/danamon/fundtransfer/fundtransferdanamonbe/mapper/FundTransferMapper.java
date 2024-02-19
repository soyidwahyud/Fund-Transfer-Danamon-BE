package com.danamon.fundtransfer.fundtransferdanamonbe.mapper;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.FundTransferRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.FundTransferResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.FundTransfer;

public interface FundTransferMapper {
    FundTransfer requestFundTransfer(FundTransferRequest request);
    FundTransferResponse responseFundTransfer(FundTransfer fundTransfer);
}
