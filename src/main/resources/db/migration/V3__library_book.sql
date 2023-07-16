CREATE TABLE library_book(
    id varchar(200) primary key not null,
    library_id integer references library(id) not null,
    book_id integer references book(id) not null,
    unique (id, library_id)
);