package com.danamon.fundtransfer.fundtransferdanamonbe.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_cust_rel",schema="danamon")
@Builder(toBuilder = true)
public class CustRel {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private String id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cust_id", nullable = false)
    private Cust cust;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "acct_id", nullable = false)
    private Acct acct;
}
