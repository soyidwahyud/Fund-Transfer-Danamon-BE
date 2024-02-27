-- auto-generated definition
create table tbl_audit_log
(
    id           varchar(36) not null
        constraint tbl_audit_log_pk
            primary key,
    created_by   varchar,
    created_time timestamp with time zone,
    detail       varchar,
    status       varchar,
    remark       varchar
);

alter table tbl_audit_log
    owner to postgres;

