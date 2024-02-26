package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustProfileRequest {
    @JsonProperty("cust_id")
    private String custId;
    @JsonProperty("username")
    private String username;
    @JsonProperty("email")
    private String email;
    @JsonProperty("fullname")
    private String fullname;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("mobile_no")
    private String mobileNo;
    @JsonProperty("atm_cif_no")
    private String atmCifNo;
    @JsonProperty("status")
    private Double status;

    @Override
    public String toString() {
        return "{" +
                "custId='" + custId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", shortName='" + shortName + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", atmCifNo='" + atmCifNo + '\'' +
                ", status=" + status +
                '}';
    }
}
