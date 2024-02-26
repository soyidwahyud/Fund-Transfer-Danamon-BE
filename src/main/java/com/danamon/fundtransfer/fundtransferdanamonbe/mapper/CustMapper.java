package com.danamon.fundtransfer.fundtransferdanamonbe.mapper;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustProfileRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustRel;

import java.util.List;

public interface CustMapper {
    Cust requestCust(CustRequest request);
    CustProfile requestCustProfile(CustProfileRequest request);
    CustResponse responseCust(Cust cust, CustProfile custProfile);

    Acct requestAcct();
    CustRel requestCustRel(Cust cust, Acct acct);

//    List<CustGetDataResponse> responseGetDataCust(String username, Cust cust, Acct acct, CustProfile custProfile);
}
