package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustRequest {
    @NotNull
    @JsonProperty("username")
    private String username;

    @NotNull
    @JsonProperty("passwd")
    private String passwd;

    @NotNull
    @JsonProperty("atm_cif_no")
    private String atmCifNo;

    @NotNull
    @JsonProperty("visa_master_cif_no")
    private String visaMasterCifNo;

    @JsonIgnore()
    private Integer registrationType;

    @NotNull
    @JsonProperty("status")
    private Double status;

    @NotNull
    @JsonProperty("cust_profile")
    private CustProfileRequest custProfileRequest;

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
