package com.danamon.fundtransfer.fundtransferdanamonbe.service;

import com.danamon.fundtransfer.fundtransferdanamonbe.dto.request.CustRequest;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustGetDataResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.dto.response.CustResponse;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Acct;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.Cust;
import com.danamon.fundtransfer.fundtransferdanamonbe.entity.CustProfile;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CustService {
    CustResponse registerCust(HttpServletRequest requestServlet, HttpServletResponse response,CustRequest request, CustResponse custResponse);
    CustGetDataResponse dataResponse(HttpServletRequest requestServlet, HttpServletResponse response,String username, Cust cust, Acct acct, CustProfile custProfile);

}
