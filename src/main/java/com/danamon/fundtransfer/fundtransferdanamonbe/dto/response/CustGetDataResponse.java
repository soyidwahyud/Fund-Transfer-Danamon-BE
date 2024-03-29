package com.danamon.fundtransfer.fundtransferdanamonbe.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedStoredProcedureQuery(name = "get_data_cust", procedureName = "get_data_cust")
@Table(schema = "danamon")
@Entity
public class CustGetDataResponse {
    @Id
    @JsonProperty("id")
    @Column
    private String id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("full_name")
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

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", noAcct='" + noAcct + '\'' +
                ", atmCifNo='" + atmCifNo + '\'' +
                ", visaMasterCifNo='" + visaMasterCifNo + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
