package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustProfileRequest {
    @NotNull
    @JsonProperty("cust_id")
    private String custId;
    @NotNull
    @JsonProperty("username")
    private String username;
    @NotNull
    @JsonProperty("email")
    private String email;
    @NotNull
    @JsonProperty("fullname")
    private String fullname;
    @NotNull
    @JsonProperty("short_name")
    private String shortName;
    @NotNull
    @JsonProperty("mobile_no")
    private String mobileNo;
    @NotNull
    @JsonProperty("atm_cif_no")
    private String atmCifNo;
    @NotNull
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
