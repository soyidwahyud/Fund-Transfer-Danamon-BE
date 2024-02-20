package com.danamon.fundtransfer.fundtransferdanamonbe.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustGetDataResponse {
    @JsonProperty("id")
    private String id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("fullname")
    private String fullName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("mobile_no")
    private String mobileNo;
    @JsonProperty("no_acct")
    private String noAcct;
    @JsonProperty("atm_cif_no")
    private String atmCifNo;
    @JsonProperty("visa_master_cif_no")
    private String visaMasterCifNo;
    @JsonProperty("balance")
    private String balance;
}
