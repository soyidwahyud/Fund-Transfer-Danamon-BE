package com.danamon.fundtransfer.fundtransferdanamonbe.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_cust_profile",schema="danamon")
@Builder(toBuilder = true)
public class CustProfile {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id")
    private Cust cust;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "short_name")
    private String shortName;
    @Column(name = "mobile_no")
    private String mobile_no;
    @Column(name = "status")
    private Double status;
}
