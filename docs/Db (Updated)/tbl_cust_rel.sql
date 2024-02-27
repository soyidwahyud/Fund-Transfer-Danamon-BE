-- auto-generated definition
create table tbl_cust_rel
(
    id      varchar(36) not null
        constraint tbl_cust_rel_pk
            primary key,
    cust_id varchar(36)
        constraint tbl_cust_rel_tbl_cust_id_fk
            references tbl_cust,
    acct_id varchar(36)
        constraint tbl_cust_rel_tbl_acct_id_fk
            references tbl_acct
);

alter table tbl_cust_rel
    owner to postgres;

