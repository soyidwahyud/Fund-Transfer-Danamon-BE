package com.danamon.fundtransfer.fundtransferdanamonbe.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferRequest {
    @NotNull
    @JsonProperty("acct_sender")
    private String acctSender;
    @NotNull
    @JsonProperty("sender_name")
    private String senderName;
    @NotNull
    @JsonProperty("acct_receiver")
    private String acctReceiver;
    @NotNull
    @JsonProperty("receiver_name")
    private String receiverName;
    @NotNull
    @JsonProperty("transfer")
    private BigDecimal transfer;
    @NotNull
    @JsonProperty("reason")
    private String reason;
    @NotNull
    @JsonProperty("status")
    private Boolean status;
    @NotNull
    @JsonProperty("transaction_type")
    private Integer transactionType;

    @Override
    public String toString() {
        return "{" +
                "acctSender='" + acctSender + '\'' +
                ", senderName='" + senderName + '\'' +
                ", acctReceiver='" + acctReceiver + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", transfer=" + transfer +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", transactionType=" + transactionType +
                '}';
    }
}
