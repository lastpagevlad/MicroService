-- сюда пишем скрипт начальной накатки базы

create table "public"."users"
(
    "id"                         bigint primary key,
    "name"                       varchar(30) not null,
    "lastname"                   varchar(30) not null,
    "surname"                    varchar(30) not null,
    "email"                      varchar(30)

);

create table "public"."message"
(
    "id"                         bigint primary key,
    "message"                    varchar(30),
    "date_sending"               timestamp without time zone default now() not null,
    "user_id"                    bigint references "public"."users" ("id") on update cascade on delete cascade
);