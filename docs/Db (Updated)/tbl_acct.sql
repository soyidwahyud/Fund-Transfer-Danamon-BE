-- auto-generated definition
create table tbl_acct
(
    id        varchar(36) not null
        constraint tbl_acct_pk
            primary key,
    no_acct   varchar(255),
    status    bigint,
    balance   numeric,
    bank_flag integer
);

alter table tbl_acct
    owner to postgres;

