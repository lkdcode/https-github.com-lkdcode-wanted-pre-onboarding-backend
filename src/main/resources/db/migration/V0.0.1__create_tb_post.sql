create table post (
id bigint       not null        auto_increment,
created_at      datetime(6),
updated_at      datetime(6),
content         varchar(255),
title           varchar(255),
member_id       bigint          not null,
primary key (id)
)