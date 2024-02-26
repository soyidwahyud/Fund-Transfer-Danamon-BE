package com.danamon.fundtransfer.fundtransferdanamonbe.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FundTransferResponse {
    @JsonProperty("id")
    private String id;
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
    @JsonProperty("admin_fee")
    private BigDecimal adminFee;
    @JsonProperty("total")
    private BigDecimal total;
    @JsonProperty("reason")
    private String reason;
    @JsonProperty("status")
    private Boolean status;
    @JsonProperty("transaction_type")
    private Integer transactionType;

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", acctSender='" + acctSender + '\'' +
                ", senderName='" + senderName + '\'' +
                ", acctReceiver='" + acctReceiver + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", transfer=" + transfer +
                ", adminFee=" + adminFee +
                ", total=" + total +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", transactionType=" + transactionType +
                '}';
    }
}
