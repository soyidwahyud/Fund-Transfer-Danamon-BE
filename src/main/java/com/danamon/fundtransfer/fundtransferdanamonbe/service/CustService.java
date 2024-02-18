package com.danamon.fundtransfer.fundtransferdanamonbe.service;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;


import java.util.List;

public interface CustService {
    CustResponse registerCust(CustRequest request);

}
