create table tbl_cust
(
    id                 uuid
        constraint tbl_cust_pk
            primary key,
    username           varchar not null,
    passwd             varchar,
    atm_cif_no         numeric,
    visa_master_cif_no numeric,
    registration_type  int,
    status             numeric
);

