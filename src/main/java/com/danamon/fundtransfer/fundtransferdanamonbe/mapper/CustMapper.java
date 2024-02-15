package com.danamon.fundtransfer.fundtransferdanamonbe.mapper;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;

public interface CustMapper {
    Cust requestCust(CustRequest request);
    CustResponse responseCust(Cust cust);
}
