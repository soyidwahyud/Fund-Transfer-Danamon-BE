package com.danamon.fundtransfer.fundtransferdanamonbe.service;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;


import java.util.List;

public interface CustService {
    CustResponse registerCust(CustRequest request);
    CustGetDataResponse dataResponse(String username, Cust cust);

}
