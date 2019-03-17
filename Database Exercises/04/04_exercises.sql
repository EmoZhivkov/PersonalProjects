select MOVIE.TITLE, MOVIEEXEC.NAME
from MOVIE JOIN MOVIEEXEC on MOVIE.PRODUCERC# = MOVIEEXEC.CERT#
where MOVIEEXEC.NAME = (select distinct MOVIEEXEC.NAME
                        from MOVIE join MOVIEEXEC ON MOVIE.PRODUCERC# = MOVIEEXEC.CERT# 
                        where TITLE = 'Star Wars')

SELECT distinct MOVIEEXEC.NAME 
from MOVIEEXEC join MOVIE on MOVIEEXEC.CERT# = MOVIE.PRODUCERC# 
               join STARSIN on MOVIE.TITLE = STARSIN.MOVIETITLE
where STARNAME = 'Harrison Ford'

select distinct STUDIO.NAME, STARSIN.STARNAME
from STUDIO join MOVIE on STUDIO.NAME = MOVIE.STUDIONAME
            join STARSIN on STARSIN.MOVIETITLE = MOVIE.TITLE
order by STUDIO.NAME

select STARSIN.STARNAME, MOVIEEXEC.NETWORTH, MOVIE.TITLE
from MOVIEEXEC join MOVIE on MOVIEEXEC.CERT# = MOVIE.PRODUCERC# 
               join STARSIN on STARSIN.MOVIETITLE = MOVIE.TITLE
where NETWORTH = (select MAX(NETWORTH) from MOVIEEXEC)

SELECT * from STARSIN

select MOVIESTAR.NAME, STARSIN.MOVIETITLE
from MOVIESTAR LEFT OUTER JOIN STARSIN ON MOVIESTAR.NAME = STARSIN.STARNAME
WHERE STARSIN.MOVIETITLE is NULL

select product.maker, product.model, product.[type]
from product LEFT OUTER JOIN (
    select laptop.model from laptop
    UNION
    select pc.model from pc
    UNION
    select printer.model from printer
) models on product.model = models.model
where models.model is NULL

select product.maker
from product join laptop on product.model = laptop.model
INTERSECT
SELECT product.maker
from product join printer on product.model = printer.model

SELECT laptop.hd
from laptop
GROUP BY hd HAVING COUNT(hd) >= 2

select pc.model
from product RIGHT OUTER JOIN pc on product.model = pc.model
WHERE product.maker is NULL

