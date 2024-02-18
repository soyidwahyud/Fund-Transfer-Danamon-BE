package com.danamon.fundtransfer.fundtransferdanamonbe.entity;


import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_cust",schema="danamon")
@Builder(toBuilder = true)
public class Cust {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private String id;
    @Column(name = "username")
    private String username;
    @Column(name = "passwd")
    private String passwd;
    @Column(name = "atm_cif_no")
    private String atmCifNo;
    @Column(name = "visa_master_cif_no")
    private String visaMasterCifNo;
    @Column(name = "registration_type")
    private Integer registrationType;
    @Column(name = "status")
    private Double status;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<CustRel> custRelSet;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "cust")
    private CustProfile custProfile;



}
