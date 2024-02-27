-- auto-generated definition
create table tbl_integration_log
(
    id             varchar(36) not null
        constraint tbl_integration_log_pk
            primary key,
    correlation_id varchar,
    activity       varchar,
    connect_string varchar,
    created_by     varchar,
    created_time   timestamp with time zone,
    request_json   varchar,
    response_json  varchar,
    request_method varchar,
    response_time  varchar,
    status_code    varchar
);

alter table tbl_integration_log
    owner to postgres;

