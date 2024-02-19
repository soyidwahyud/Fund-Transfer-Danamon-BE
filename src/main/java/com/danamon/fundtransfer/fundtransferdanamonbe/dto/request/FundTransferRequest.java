package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferRequest {
    @JsonProperty("acct_sender")
    private String acctSender;
    @JsonProperty("sender_name")
    private String senderName;
    @JsonProperty("acct_receiver")
    private String acctReceiver;
    @JsonProperty("receiver_name")
    private String receiverName;
    @JsonProperty("transfer")
    private BigDecimal transfer;
//    @JsonProperty("admin_fee")
//    private BigDecimal adminFee;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private Boolean status;
}
