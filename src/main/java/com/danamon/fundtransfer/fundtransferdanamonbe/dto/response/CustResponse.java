package com.danamon.fundtransfer.fundtransferdanamonbe.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("passwd")
    private String passwd;

    @JsonProperty("atm_cif_no")
    private String atmCifNo;

    @JsonProperty("visa_master_cif_no")
    private String visaMasterCifNo;

    @JsonProperty("registration_type")
    private Integer registrationType;

    @JsonProperty("status")
    private Double status;

    @JsonProperty("cust_profile")
    private CustProfileResponse custProfileResponse;

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", atmCifNo='" + atmCifNo + '\'' +
                ", visaMasterCifNo='" + visaMasterCifNo + '\'' +
                ", registrationType=" + registrationType +
                ", status=" + status +
                ", custProfileResponse=" + custProfileResponse.toString() +
                '}';
    }
}
