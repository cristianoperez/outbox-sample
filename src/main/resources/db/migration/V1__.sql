create table outbox
(
    id            bigserial    not null
        constraint outbox_pk
            primary key,
    aggregateid   varchar(255) not null,
    aggregatetype varchar(255) not null,
    payload       text,
    type          varchar(255) not null,
	timestamp     bigint not null;
);

create table users
(
    id         bigserial    not null
        constraint users_pk
            primary key,
    firstName varchar(255) not null,
    lastName  varchar(255) not null
);