package com.danamon.fundtransfer.fundtransferdanamonbe.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginResponse {
    private boolean success;
    private String message;
    private String token;
    private CustDetails custDetails;

    public void setCustDetails(String username, String id) {
        this.custDetails = new CustDetails(username, id);
    }
}
