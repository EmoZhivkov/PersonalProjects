SELECT NAME FROM MOVIEEXEC
WHERE NETWORTH > 10000000 AND 
NAME = ANY (SELECT NAME from MOVIESTAR where GENDER = 'F')

SELECT NAME FROM MOVIESTAR
WHERE NAME != ANY (SELECT NAME FROM MOVIEEXEC)

SELECT TITLE FROM MOVIE 
WHERE LENGTH > ANY (SELECT LENGTH FROM MOVIE WHERE TITLE = 'Star Wars')

SELECT TITLE, NAME 
FROM MOVIE JOIN MOVIEEXEC ON MOVIE.PRODUCERC# = MOVIEEXEC.CERT#
WHERE NETWORTH > ANY (SELECT NETWORTH FROM MOVIEEXEC WHERE NAME = 'Merv Griffin')

Select distinct MAKER 
FROM product join pc on product.model = pc.model
where speed > 500

Select code, model, price
from printer 
where price = (select MAX(price) from printer)

select * from laptop
where speed < (SELECT MIN(speed) from pc)

select T.model, T.price from 
    (select model, price from laptop 
    UNION 
    select model, price from pc 
    UNION 
    select model, price from printer) as T
WHERE T.price = (SELECT MAX(T.price) from (select price from laptop 
    UNION 
    select price from pc 
    UNION 
    select price from printer) as T)

SELECT * from printer

select maker
from product join printer on product.model = printer.model
where color = 'y' AND price = (select MIN(price) from printer where color = 'y')

SELECT maker from product join pc on product.model = pc.model
where ram = (select MIN(ram) from pc) AND 
speed = (SELECT MAX(speed) from product join pc on product.model = pc.model
where ram = (select MIN(ram) from pc))

select distinct COUNTRY 
FROM CLASSES
where NUMGUNS = (SELECT MAX(NUMGUNS) from CLASSES)

select distinct CLASS FROM SHIPS JOIN OUTCOMES on SHIPS.NAME = OUTCOMES.SHIP
where RESULT = 'sunk'

select NAME, CLASSES.CLASS FROM CLASSES JOIN SHIPS on CLASSES.CLASS = SHIPS.CLASS
where BORE = 16

select BATTLES.NAME 
FROM BATTLES JOIN OUTCOMES on BATTLES.NAME = OUTCOMES.BATTLE
JOIN SHIPS on OUTCOMES.SHIP = SHIPS.NAME
WHERE SHIPS.CLASS = 'Kongo'

select T.CLASS, T.NAME from
(select CLASSES.CLASS, CLASSES.BORE, CLASSES.NUMGUNS, NAME
from CLASSES join SHIPS on CLASSES.CLASS = SHIPS.CLASS) as T,
(select MAX(NUMGUNS) as MAXNUMGUNS, BORE as BORESEC from CLASSES GROUP BY BORE) as T1
WHERE T.BORE = T1.BORESEC AND T.NUMGUNS = T1.MAXNUMGUNS
ORDER BY T.CLASS

select *
from classes c1 join SHIPS on SHIPS.CLASS = c1.CLASS
where c1.NUMGUNS >= ALL (select NUMGUNS from CLASSES c2 where c1.BORE = c2.BORE)
ORDER BY c1.CLASS

select MAX(NUMGUNS) as MAXNUMGUNS, BORE from CLASSES GROUP BY BORE