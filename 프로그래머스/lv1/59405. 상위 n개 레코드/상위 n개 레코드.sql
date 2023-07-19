-- 테이블에서 가장 일찍 들어온 동물 2마리 출력
select NAME
from ANIMAL_INS 
order by DATETIME
limit 1;