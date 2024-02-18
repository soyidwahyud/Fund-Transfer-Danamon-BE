package com.danamon.fundtransfer.fundtransferdanamonbe.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustProfileResponse {
    @JsonProperty("id")
    private String id;
    @JsonProperty("cust_id")
    private String custId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("fullname")
    private String fullName;
    @JsonProperty("shortName")
    private String shortName;
    @JsonProperty("mobile_no")
    private String mobileNo;
    @JsonProperty("status")
    private Double status;
}
