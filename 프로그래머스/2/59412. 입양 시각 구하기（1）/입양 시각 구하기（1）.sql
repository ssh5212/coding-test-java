-- 코드를 입력하세요
select hour(datetime) as hour, count(*) as count
from ANIMAL_OUTS 
group by hour
having 1
    and hour >= 9
    and hour <= 19
order by hour asc