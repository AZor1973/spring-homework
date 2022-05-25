CREATE TABLE students
(
    id           bigserial primary key,
    name        varchar(255) not null,
    age     int
);

DROP TABLE students;