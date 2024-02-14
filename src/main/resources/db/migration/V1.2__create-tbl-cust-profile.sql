create table tbl_cust_profile
(
    id         uuid    not null
        constraint tbl_cust_profile_pk
            primary key,
    cust_id    uuid
        constraint tbl_cust_profile_tbl_cust_id_fk
            references danamon.tbl_cust,
    username   varchar not null,
    email      varchar,
    fullname   varchar,
    short_name varchar,
    mobile_no  varchar,
    atm_cif_no numeric,
    status     numeric
);

