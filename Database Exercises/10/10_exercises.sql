create database flights

create table airline(
    code char(2) NOT NULL,
    name varchar(30),
    country varchar(30)
)

create table airplane(
    code char(3) not null,
    type varchar(50),
    seats INT,
    year INT
)

create table booking(
    code char(6) not null,
    agency varchar(30) not null,
    airline_code char(2) not null,
    flight_number char(6) not null,
    customer_id INT not null ,
    booking_date DATE,
    flight_date DATE,
    price INT,
    status INT not null
)

create table flight(
    fnumber char(6) not null,
    airline_operator char(2) not null,
    dep_airport char(3) not null,
    arr_airport char(3) not null,
    flight_time TIME,
    flight_duration INT,
    airplane char(3) not null
)

create table agency(
    name varchar(30) not null,
    country varchar(30),
    city varchar(30),
    phone varchar(30)
)

create table customer(
    id INT not null,
    fname varchar(30),
    lname varchar(30),
    email varchar(30)
)

drop table airport
create table airport(
    code char(3) not null,
    name varchar(30),
    country varchar(30),
    city varchar(30)
)

alter table airline add constraint pk_airline primary key(code)
alter table airplane add constraint pk_airplane primary key(code)
alter table agency add constraint  pk_agency primary key(name)
alter table customer add constraint pk_customer primary key(id)
alter table airport add constraint pk_airport primary key(code)
alter table flight add constraint pk_flight primary key(fnumber)
alter table booking add constraint pk_booking primary key(code)

alter table flight add constraint fk_flight_airline foreign key(airline_operator) references airline(code)
alter table flight add constraint fk_flight_aairport foreign key(arr_airport) references airport(code)
alter table flight add constraint fk_flight_dairport foreign key(dep_airport) references airport(code)
alter table flight add constraint fk_flight_airplane foreign key(airplane) references airplane(code)

alter table booking add constraint fk_booking_agency foreign key(agency) references agency(name)
alter table booking add constraint fk_booking_airline foreign key(airline_code) references airline(code)
alter table booking add constraint fk_booking_flight foreign key(flight_number) references flight(fnumber)
alter table booking add constraint fk_booking_customer foreign key(customer_id) references customer(id)
