create table outbox
(
    id             bigserial    not null
        constraint outbox_pk
            primary key,
    aggregate_root varchar(255) not null,
    event_type     varchar(100) not null,
    payload        text
);

create table users
(
    id         bigserial    not null
        constraint users_pk
            primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null
);