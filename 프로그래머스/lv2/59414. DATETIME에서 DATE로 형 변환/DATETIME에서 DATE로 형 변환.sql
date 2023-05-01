-- 코드를 입력하세요
select animal_id, name, date_format(DATETIME, "%Y-%m-%d")
from animal_ins
order by animal_id