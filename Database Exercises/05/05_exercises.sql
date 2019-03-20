select AVG(pc.speed)
from pc

select product.maker, AVG(laptop.screen)
from product join laptop on product.model = laptop.model
GROUP by product.maker

select AVG(laptop.speed)
from laptop 
where laptop.price > 1000

select AVG(pc.price)
from product join pc on product.model = pc.model
where product.maker = 'A'

SELECT product.maker, AVG(T.price) as AvgPrice from product join 
(select laptop.model, laptop.price from laptop
UNION ALL
select pc.model, pc.price from pc) T on product.model = T.model
where product.maker = 'B'
GROUP BY product.maker

select pc.speed, AVG(pc.price)
from pc
GROUP BY pc.speed

select product.maker, COUNT(pc.model) from product join pc on product.model = pc.model
GROUP by product.maker HAVING COUNT(pc.model) >= 3

select product.maker, pc.price 
from product join pc on product.model = pc.model
where pc.price = (select MAX(pc.price) from pc)

select pc.speed, AVG(pc.price) as AvgPrice
from pc
where pc.speed > 800
GROUP BY pc.speed

select product.maker, AVG(pc.hd)
from product join (
    select pc.model from pc
    UNION
    select printer.model from printer
)

select maker, AVG(pc.hd)
from product join pc on product.model = pc.model
where maker = ANY(select product.maker from product join printer on product.model = printer.model
                  INTERSECT
                  select product.maker from product join pc on product.model = pc.model)
GROUP BY maker

select COUNT(CLASSES.CLASS)
from CLASSES
WHERE CLASSES.[TYPE] = 'bb'

select CLASSES.CLASS, AVG(CLASSES.NUMGUNS)
FROM CLASSES
GROUP BY CLASSES.CLASS

SELECT AVG(CLASSES.NUMGUNS)
FROM CLASSES 
WHERE [TYPE] = 'bb'

SELECT first.CLASS, first.min, second.max
from 
(select CLASSES.CLASS, MIN(SHIPS.LAUNCHED) as min from CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
GROUP BY CLASSES.CLASS) as first
join
(select CLASSES.CLASS, MAX(SHIPS.LAUNCHED) as max from CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
GROUP BY CLASSES.CLASS) as second
on [first].CLASS = second.CLASS

select CLASSES.CLASS, MIN(SHIPS.LAUNCHED), MAX(SHIPS.LAUNCHED)
FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
GROUP BY CLASSES.CLASS

SELECT SHIPS.CLASS, COUNT(ships.NAME)
FROM SHIPS JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
where OUTCOMES.RESULT = 'sunk'
GROUP BY ships.CLASS

select T.CLASS, cnt from
(SELECT SHIPS.CLASS, COUNT(ships.NAME) as cnt
FROM SHIPS JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
where OUTCOMES.RESULT = 'sunk' 
GROUP BY ships.CLASS ) as T
join
(SELECT SHIPS.CLASS
FROM SHIPS JOIN CLASSES ON SHIPS.CLASS = CLASSES.CLASS
GROUP by ships.CLASS having COUNT(SHIPS.NAME) > 2 ) as T1
on T.CLASS = T1.CLASS

select CLASSES.COUNTRY, AVG(CLASSES.BORE)
FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
GROUP BY CLASSES.COUNTRY