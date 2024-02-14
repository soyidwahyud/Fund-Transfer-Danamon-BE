create table danamon.tbl_cust_rel
(
    id      uuid not null
        constraint tbl_cust_rel_pk
            primary key,
    cust_id uuid
        constraint tbl_cust_rel_tbl_cust_id_fk
            references danamon.tbl_cust,
    acct_id uuid
        constraint tbl_cust_rel_tbl_acct_id_fk
            references danamon.tbl_acct
);

