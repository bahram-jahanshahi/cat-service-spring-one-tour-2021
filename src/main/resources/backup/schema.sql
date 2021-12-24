create sequence if not exists hibernate_squence start 1 increment 1;

create table if not exists cat (
    id int4 not null,
    name varchar(255),
    age_in_months int,
    primary key (id)
)