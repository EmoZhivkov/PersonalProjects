create database facebook
create table users(
    id INT,
    email VARCHAR(32),
    password varchar(16),
    regDate DATE
)

create table friends(
    first INT,
    second INT
)

create table walls(
    idUser INT,
    idWriteUser INT,
    text varchar(144),
    date DATE
)

create table groups(
    id INT,
    name varchar(32),
    description varchar(50) default ''
)

create table group_members(
    idGroup INT,
    idUser INT
)

insert users(id, email, password, regDate)
values (1, 'emo@yahoo.com', 'jcnskdjc', '2019-04-20')
insert users(id, email, password, regDate)
values (2, 'gosho@yahoo.com', 'ldknm', '2019-04-20')

select * from users

insert friends(first, second) values (1, 2)

select * from friends

insert walls(idUser, idWriteUser, text, date)
values (1, 2, 'who tf are you?', '2019-04-21')

select * from walls

insert into groups(id, name, description) values (233, 'banda', 'mn qka')
delete groups where description = ''

select * from groups

insert into group_members(idGroup, idUser) values (233, 1)

select * from group_members

drop table group_members

alter table walls drop column date

select * from walls