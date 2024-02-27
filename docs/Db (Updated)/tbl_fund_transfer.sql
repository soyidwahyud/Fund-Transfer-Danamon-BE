-- auto-generated definition
create table tbl_fund_transfer
(
    id               varchar(36) not null
        constraint tbl_fund_transfer_pk
            primary key,
    acct_sender      varchar(255),
    sender_name      varchar(255),
    acct_receiver    varchar(255),
    receiver_name    varchar(255),
    admin_fee        numeric,
    reason           varchar(255),
    status           boolean,
    transfer         numeric,
    total            numeric,
    transaction_type integer
);

alter table tbl_fund_transfer
    owner to postgres;

