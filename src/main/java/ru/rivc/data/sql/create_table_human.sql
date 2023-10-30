CREATE TABLE HUMAN (
    id integer primary key ,
    name varchar(256),
    birthday timestamp,
    nationality varchar(64),
    qualifications varchar(64)
);

select * from HUMAN where nationality is not null and qualifications like 'ENGINEER' and (year(birthday) >= 1990 and year(birthday) <= 1992)