package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustRequest {
    @JsonProperty("username")
    private String username;

    @JsonProperty("passwd")
    private String passwd;

    @JsonProperty("atm_cif_no")
    private String atmCifNo;

    @JsonProperty("visa_master_cif_no")
    private String visaMasterCifNo;

    @JsonIgnore()
    private Integer registrationType;

    @JsonProperty("status")
    private Double status;

    @JsonProperty("cust_profile")
    private CustProfileRequest custProfileRequest;

    private Set<String> role;

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", atmCifNo='" + atmCifNo + '\'' +
                ", visaMasterCifNo='" + visaMasterCifNo + '\'' +
                ", registrationType=" + registrationType +
                ", status=" + status +
                ", custProfileRequest=" + custProfileRequest.toString() +
                '}';
    }
}
