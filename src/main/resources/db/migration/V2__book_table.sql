CREATE TABLE book(
    id serial primary key,
    name varchar(500) not null,
    author varchar(500) not null,
    isbn varchar(50) not null
);