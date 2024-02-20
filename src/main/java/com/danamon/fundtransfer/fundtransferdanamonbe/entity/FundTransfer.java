package com.danamon.fundtransfer.fundtransferdanamonbe.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_fund_transfer",schema="danamon")
@Builder(toBuilder = true)
public class FundTransfer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private String id;
    @Column(name = "acct_sender")
    private String acctSender;
    @Column(name = "sender_name")
    private String senderName;
    @Column(name = "acct_receiver")
    private String acctReceiver;
    @Column(name = "receiver_name")
    private String receiverName;
    @Column(name = "transfer")
    private BigDecimal transfer;
    @Column(name = "admin_fee")
    private BigDecimal adminFee;
    @Column(name="total")
    private BigDecimal total;
    @Column(name = "reason")
    private String reason;
    @Column(name = "status")
    @Builder.Default
    private Boolean status = true;
    @Column(name = "transaction_type")
    private Integer transactionType;
}
