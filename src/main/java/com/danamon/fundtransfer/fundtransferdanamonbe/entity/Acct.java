package com.danamon.fundtransfer.fundtransferdanamonbe.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_acct",schema="danamon")
@Builder(toBuilder = true)
public class Acct {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private String id;
    @Column(name = "no_acct")
    private Integer noAcct;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<CustRel> custRelSet;
}
