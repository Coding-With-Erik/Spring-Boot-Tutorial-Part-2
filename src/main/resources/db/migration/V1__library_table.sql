CREATE TABLE library (
    id serial primary key,
    name varchar(200) not null,
    email varchar(200),
    website varchar(200),
    address varchar(200)
);