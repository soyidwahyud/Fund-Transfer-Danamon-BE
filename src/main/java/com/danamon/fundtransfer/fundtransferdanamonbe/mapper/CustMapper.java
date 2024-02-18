package com.danamon.fundtransfer.fundtransferdanamonbe.mapper;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustProfileRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;

public interface CustMapper {
    Cust requestCust(CustRequest request);
    CustProfile requestCustProfile(CustProfileRequest request);
    CustResponse responseCust(Cust cust, CustProfile custProfile);
}
