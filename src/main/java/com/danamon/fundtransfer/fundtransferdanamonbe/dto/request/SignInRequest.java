package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

@Data
public class SignInRequest {
    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String passwd;
}
