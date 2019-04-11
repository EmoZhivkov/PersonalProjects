select * from MOVIESTAR

insert into MOVIESTAR(NAME, BIRTHDATE)
VALUES('Nicole Kidman', '1967-06-20')

delete 
from MOVIEEXEC 
where NETWORTH < 30000000

delete from MOVIESTAR where ADDRESS is NULL

select * from pc

insert into pc(code, model, speed, ram, hd, cd, price)
VALUES(12, '1100', 2400, 2048, 500, '52x', 299)

select * from product

insert into product(maker, model, type)
values('C', '1100', 'PC')

delete from pc where model = '1100'
delete from product where model = '1100'

delete from laptop 
where model != ALL (select product.model
                                      from laptop join product on laptop.model = product.model
                                      where product.maker != ALL (select distinct product.maker 
                                                                  from product join printer on product.model = printer.model))

select * from product

update product SET maker = 'A' where product.maker = 'A'

update pc set price = price/2, hd = hd + 20 

update laptop set screen = screen + 1 where model = (select product.model from 
                                                     product join )