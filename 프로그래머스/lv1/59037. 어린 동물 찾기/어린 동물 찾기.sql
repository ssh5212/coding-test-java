-- 코드를 입력하세요
select animal_id, name
from animal_ins
where INTAKE_CONDITION != "aged"
order by ANIMAL_ID asc;