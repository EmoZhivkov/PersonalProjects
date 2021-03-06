select MOVIE.TITLE, MOVIE.YEAR, MOVIE.LENGTH
FROM MOVIE
WHERE YEAR < 2000 AND (LENGTH > 120 OR LENGTH IS NULL) 

SELECT MOVIESTAR.NAME, MOVIESTAR.GENDER
FROM MOVIESTAR
WHERE NAME LIKE 'J%' AND BIRTHDATE > 1948
ORDER BY NAME DESC

SELECT STUDIO.NAME, COUNT(DISTINCT STARSIN.STARNAME)
FROM STUDIO JOIN MOVIE ON STUDIO.NAME = MOVIE.STUDIONAME
            JOIN STARSIN ON STARSIN.MOVIETITLE = MOVIE.TITLE
GROUP BY STUDIO.NAME

SELECT STARSIN.STARNAME, COUNT(MOVIE.TITLE)
FROM MOVIE JOIN STARSIN ON MOVIE.TITLE = STARSIN.MOVIETITLE
GROUP BY STARNAME

SELECT * FROM MOVIE

SELECT STUDIONAME, TITLE, YEAR
FROM MOVIE M1 
WHERE YEAR >= ALL (SELECT YEAR FROM MOVIE M2 WHERE
                    M1.STUDIONAME = M2.STUDIONAME)

SELECT NAME 
FROM MOVIESTAR 
WHERE NAME = (SELECT NAME FROM MOVIESTAR WHERE BIRTHDATE = (SELECT MIN(BIRTHDATE) FROM MOVIESTAR WHERE GENDER = 'M') )


SELECT * FROM (
    SELECT STUDIONAME, STARSIN.STARNAME, COUNT(MOVIE.TITLE) AS NUM_MOVIES
    FROM MOVIE JOIN STARSIN ON MOVIE.TITLE = STARSIN.MOVIETITLE
    GROUP BY STUDIONAME, STARNAME
) M1 WHERE M1.NUM_MOVIES = (SELECT MAX(NUM_MOVIES)
                            FROM (SELECT STUDIONAME, STARSIN.STARNAME, COUNT(MOVIE.TITLE) AS NUM_MOVIES
    FROM MOVIE JOIN STARSIN ON MOVIE.TITLE = STARSIN.MOVIETITLE
    GROUP BY STUDIONAME, STARNAME) M2)

SELECT * FROM (
    SELECT MOVIE.TITLE, MOVIE.YEAR, COUNT(STARSIN.STARNAME) AS NUM_ACTORS
    FROM MOVIE JOIN STARSIN ON MOVIE.TITLE = STARSIN.MOVIETITLE
    GROUP BY MOVIE.TITLE, MOVIE.YEAR
) M1 WHERE NUM_ACTORS > 2

SELECT DISTINCT SHIPS.NAME
FROM SHIPS JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
WHERE SHIPS.NAME LIKE 'C%' OR SHIPS.NAME LIKE 'K%'

SELECT * FROM OUTCOMES

SELECT DISTINCT SHIPS.NAME, CLASSES.COUNTRY
FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
             LEFT OUTER JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
WHERE OUTCOMES.RESULT != 'sunk' OR OUTCOMES.RESULT IS NULL

SELECT CLASSES.COUNTRY, COUNT(SHIP) AS NUM_SHIPS
FROM (CLASSES LEFT JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS)
             LEFT JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
WHERE OUTCOMES.RESULT = 'sunk' OR SHIP IS NULL
GROUP BY CLASSES.COUNTRY


SELECT BATTLE FROM (
SELECT BATTLE, COUNT(SHIP) AS SHIP_COUNT
FROM SHIPS JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
GROUP BY BATTLE
) M WHERE M.SHIP_COUNT > (SELECT SHIP_COUNT FROM 
    (SELECT BATTLE, COUNT(SHIP) AS SHIP_COUNT
    FROM SHIPS JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
    GROUP BY BATTLE ) M1
    WHERE M1.BATTLE = 'Guadalcanal')


SELECT BATTLE FROM 
(SELECT BATTLE, COUNT(CLASSES.COUNTRY) AS COUNTR_COUNT
FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
             JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
GROUP BY BATTLE) M WHERE M.COUNTR_COUNT > (
    SELECT COUNTR_COUNT FROM
    (SELECT BATTLE, COUNT(CLASSES.COUNTRY) AS COUNTR_COUNT
    FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
                 JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
    GROUP BY BATTLE) M2 WHERE BATTLE = 'Surigao Strait'
)

SELECT NAME, DISPLACEMENT, NUMGUNS
FROM CLASSES C JOIN SHIPS S ON C.CLASS = S.CLASS
WHERE DISPLACEMENT <= ALL(SELECT DISPLACEMENT FROM CLASSES) AND NUMGUNS >= ALL (SELECT NUMGUNS FROM CLASSES WHERE DISPLACEMENT = C.DISPLACEMENT)

SELECT SHIP as num_ships
FROM BATTLES JOIN OUTCOMES o ON NAME = BATTLE 
WHERE RESULT = 'damaged' 
AND DATE <= ANY (SELECT DATE 
                 FROM BATTLES JOIN OUTCOMES o1 ON NAME = BATTLE 
                 WHERE o1.RESULT='ok' and o.SHIP = o1.SHIP and 
                 NAME = ANY (
                     SELECT NAME
                     FROM BATTLES JOIN OUTCOMES A ON NAME = BATTLE
                     GROUP BY NAME
                     HAVING COUNT(SHIP) > (
                         SELECT COUNT(SHIP)
                         FROM OUTCOMES JOIN BATTLES B ON NAME = BATTLE
                         WHERE NAME = B.NAME
                         GROUP BY NAME
                     )
                 ))

SELECT product.model, laptop.code, laptop.screen
from product join laptop on product.model = laptop.model
where screen = 11 or screen = 15


select distinct model from pc 
where price < (select MIN(price) from laptop)

select product.model from product join 
(select model, price from laptop
UNION
select model, price from pc) a on product.model = a.model

select product.model
from product pr join pc on pr.model = pc.model
where pc.price < ALL( select laptop.price
                      from laptop join product pr1 on laptop.model = pr1.model
                      where pr.maker = pr1.maker )

------------------
--Second Try
------------------

SELECT MOVIE.TITLE, MOVIE.YEAR,MOVIE.LENGTH
FROM MOVIE
WHERE (LENGTH > 120 OR LENGTH IS NULL) AND YEAR < 2000 


SELECT MOVIESTAR.NAME, MOVIESTAR.GENDER
FROM MOVIESTAR
WHERE BIRTHDATE > 1948 AND NAME LIKE 'J%'
ORDER BY NAME DESC

SELECT STUDIO.NAME, COUNT(DISTINCT STARSIN.STARNAME)
FROM STUDIO JOIN MOVIE ON STUDIO.NAME = MOVIE.STUDIONAME
            JOIN STARSIN ON MOVIE.TITLE = STARSIN.MOVIETITLE
GROUP BY STUDIO.NAME

SELECT STARSIN.STARNAME, COUNT(MOVIE.TITLE) AS NUM_MOVIES
FROM MOVIE JOIN STARSIN ON TITLE = MOVIETITLE
GROUP BY STARNAME

SELECT M1.STUDIONAME, M1.TITLE, M1.YEAR
FROM MOVIE M1 
WHERE M1.YEAR >= ALL (SELECT M2.YEAR FROM MOVIE M2 WHERE M1.STUDIONAME = M2.STUDIONAME)

SELECT M1.NAME
FROM MOVIESTAR M1
WHERE M1.GENDER = 'M' AND M1.BIRTHDATE >= ALL (SELECT M2.BIRTHDATE FROM MOVIESTAR M2 WHERE GENDER = 'M')

SELECT *
FROM (
    SELECT STUDIONAME, STARSIN.STARNAME, COUNT(TITLE) AS NUM_MOVIES
    FROM MOVIE JOIN STARSIN ON MOVIE.TITLE = STARSIN.MOVIETITLE
    GROUP BY STUDIONAME, STARNAME) AS M1 
WHERE NUM_MOVIES = (SELECT MAX(NUM_MOVIES)
                   FROM 
    (SELECT STUDIONAME, STARSIN.STARNAME, COUNT(TITLE) AS NUM_MOVIES
    FROM MOVIE JOIN STARSIN ON MOVIE.TITLE = STARSIN.MOVIETITLE
    GROUP BY STUDIONAME, STARNAME) AS M2)

SELECT MOVIE.TITLE, STARSIN.MOVIEYEAR, COUNT(STARSIN.STARNAME) 
FROM MOVIE JOIN STARSIN ON TITLE = MOVIETITLE
GROUP BY MOVIE.TITLE, STARSIN.MOVIEYEAR
HAVING COUNT(STARNAME) > 2

SELECT DISTINCT SHIPS.NAME
FROM SHIPS JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
WHERE SHIPS.NAME LIKE 'C%' OR SHIPS.NAME LIKE 'K%'

SELECT DISTINCT SHIPS.NAME, CLASSES.COUNTRY 
FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
             LEFT JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
WHERE OUTCOMES.RESULT NOT LIKE 'sunk' OR OUTCOMES.SHIP IS NULL

SELECT CLASSES.COUNTRY, COUNT(OUTCOMES.SHIP)
FROM CLASSES LEFT JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
             LEFT JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
WHERE OUTCOMES.RESULT LIKE 'sunk' OR SHIPS.NAME IS NULL OR OUTCOMES.SHIP IS NULL
GROUP BY COUNTRY

SELECT BATTLE
FROM OUTCOMES 
GROUP BY BATTLE
HAVING COUNT(OUTCOMES.SHIP) > (SELECT COUNT(OUTCOMES.SHIP)
                               FROM OUTCOMES
                               WHERE BATTLE LIKE 'Guadalcanal')

SELECT BATTLE
FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
             JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
GROUP BY BATTLE
HAVING COUNT(COUNTRY) > (SELECT COUNT(CLASSES.COUNTRY)
                         FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
                         JOIN OUTCOMES ON SHIPS.NAME = OUTCOMES.SHIP
                         WHERE BATTLE LIKE 'Surigao Strait' )

SELECT SHIPS.NAME, CLASSES.DISPLACEMENT, CLASSES.NUMGUNS
FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
WHERE DISPLACEMENT = (SELECT MIN(DISPLACEMENT)
                      FROM CLASSES) 
  AND NUMGUNS = (SELECT MAX(NUMGUNS)
                 FROM (SELECT SHIPS.NAME, CLASSES.DISPLACEMENT, CLASSES.NUMGUNS
                       FROM CLASSES JOIN SHIPS ON CLASSES.CLASS = SHIPS.CLASS
                       WHERE DISPLACEMENT = (SELECT MIN(DISPLACEMENT)
                                             FROM CLASSES)) AS M)

SELECT o.SHIP
FROM OUTCOMES o JOIN BATTLES B ON o.BATTLE = B.NAME
WHERE o.RESULT LIKE 'damaged' AND 
      B.DATE <= ANY (SELECT B1.[DATE]
                FROM BATTLES B1 JOIN OUTCOMES o1 ON BATTLE = NAME
                WHERE o.SHIP = o1.SHIP AND [RESULT] LIKE 'ok' AND
                NAME LIKE ANY (SELECT NAME
                               FROM))

 