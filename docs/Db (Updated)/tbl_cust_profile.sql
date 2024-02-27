-- auto-generated definition
create table tbl_cust_profile
(
    id         varchar(36)  not null
        constraint tbl_cust_profile_pk
            primary key,
    cust_id    varchar(36)
        constraint fkte9tib4ygyo1oaaufyf7xrjs
            references tbl_cust,
    username   varchar(255) not null,
    email      varchar(255),
    full_name  varchar(255),
    short_name varchar(255),
    mobile_no  varchar(255),
    status     double precision
);

alter table tbl_cust_profile
    owner to postgres;

