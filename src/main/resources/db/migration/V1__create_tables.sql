create table bookmarks
(
    id         bigserial primary key,
    title      varchar not null,
    url        varchar not null,
    created_at timestamp
);

create table users
(
    id       bigserial primary key,
    name     varchar,
    username varchar not null unique,
    email    varchar not null unique,
    phone    varchar,
    website  varchar
);