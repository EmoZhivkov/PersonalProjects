alter table FLIGHTS add num_pass int default 0
alter table AGENCIES add num_book int default 0

create trigger increase_num_book on BOOKINGS
after INSERT AS
    UPDATE FLIGHTS SET FLIGHTS.num_pass = FLIGHTS.num_pass + 1

CREATE TRIGGER increase_num_pass on BOOKINGS
after insert as
    update AGENCIES set AGENCIES.num_book = AGENCIES.num_book + 1

create trigger edi_kwo_si on BOOKINGS
after update as
    update FLIGHTS set FLIGHTS.num_pass = FLIGHTS.num_pass + (select BOOKINGS.STATUS
                                                              from BOOKINGS
                                                              where BOOKINGS.FLIGHT_NUMBER = FLIGHTS.FNUMBER)