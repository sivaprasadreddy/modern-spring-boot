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
    username varchar,
    email    varchar,
    phone    varchar,
    website  varchar
);