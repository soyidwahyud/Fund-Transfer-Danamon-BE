package com.danamon.fundtransfer.fundtransferdanamonbe.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_integration_log",schema="danamon")
@Builder(toBuilder = true)
public class IntegrationLog {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "id", length = 36, updatable = false, nullable = false)
    private String id;

    @Column(name = "correlation_id", updatable = false, nullable = false)
    private String correlationId;

    @Column(name = "activity")
    private String activity;
    @Column(name = "connect_string")
    private String connectString;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_time",columnDefinition = "TIMESTAMP WITH TIMEZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime ;
    @Column(name = "request_json")
    private String requestJson;
    @Column(name = "response_json")
    private String responseJson;
    @Column(name = "request_method")
    private String requestMethod;
    @Column(name = "response_time")
    private Long responseTime ;
    @Column(name = "status_code")
    private Integer statusCode;

}
