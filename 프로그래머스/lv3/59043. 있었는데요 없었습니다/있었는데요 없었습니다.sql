-- 코드를 입력하세요
select I.ANIMAL_ID, I.NAME
from ANIMAL_INS I join ANIMAL_OUTS O
    on I.ANIMAL_ID = O.ANIMAL_ID
where I.DATETIME > O.DATETIME
order by I.DATETIME asc;

# select ANIMAL_ID, NAME
# from ANIMAL_INS
# where DATETIME any (select DATETIME
#                   from ANIMAL_OUTS)
# order by DATETIME asc;