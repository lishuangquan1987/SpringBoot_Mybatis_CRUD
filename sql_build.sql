-- auto-generated definition
create table mvctest20200229
(
    id       int auto_increment
        primary key,
    add_time datetime default CURRENT_TIMESTAMP null,
    name     varchar(45)                        null,
    age      int                                null,
    remark   varchar(45)                        null
);

