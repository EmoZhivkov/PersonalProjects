create view airline_operator_flight_passengers as
select FLIGHT_NUMBER, NAME, COUNT(C.ID) AS NUM_PASSENGERS
from BOOKINGS join AIRLINES on BOOKINGS.AIRLINE_CODE = AIRLINES.CODE
               JOIN FLIGHTS on BOOKINGS.FLIGHT_NUMBER = FLIGHTS.FNUMBER
               JOIN CUSTOMERS C ON CUSTOMER_ID = C.ID
WHERE STATUS = 1
GROUP BY FLIGHT_NUMBER, NAME

CREATE VIEW agency_most_flying_client as
select A.NAME, C.FNAME
FROM AGENCIES A JOIN BOOKINGS B ON A.NAME = B.AGENCY JOIN CUSTOMERS C on B.CUSTOMER_ID = C.ID
GROUP BY A.NAME, C.FNAME
HAVING COUNT(B.CODE) >= ALL (SELECT COUNT(B1.CODE) AS NUM_BOOKINGS
                        FROM CUSTOMERS JOIN BOOKINGS B1 on CUSTOMERS.ID = B1.CUSTOMER_ID
                                       JOIN AGENCIES A1 on B1.AGENCY = A1.NAME
                        WHERE A.NAME = A1.NAME
                        GROUP BY CUSTOMERS.FNAME, A1.NAME)

create view sofia_agencies as
select * from AGENCIES where CITY = 'Sofia'
with check option

create view null_numbers as
    select * from AGENCIES where PHONE is null
    with  check option

create view rich_exec as
    select * from MOVIEEXEC
    where NETWORTH >= 10000000

create index movie_title on MOVIE(TITLE)
