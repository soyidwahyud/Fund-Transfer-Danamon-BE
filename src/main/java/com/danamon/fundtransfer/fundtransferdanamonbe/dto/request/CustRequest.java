package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
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

    private Set<String> role;

}
