-- сюда пишем скрипт начальной накатки базы

create table "public"."users"
(
    "id"                         bigint primary key,
    "name"                       varchar(30),
    "email"                      varchar(30)
);

create table "public"."messages"
(
    "id"                         bigint primary key,
    "message"                    varchar(30),
    "user_id"                    bigint references "public"."users" ("id") on update cascade on delete cascade
);