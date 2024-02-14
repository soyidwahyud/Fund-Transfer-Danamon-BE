create table danamon.tbl_acct
(
    id      uuid not null
        constraint tbl_acct_pk
            primary key,
    no_acct numeric,
    status  numeric
);

