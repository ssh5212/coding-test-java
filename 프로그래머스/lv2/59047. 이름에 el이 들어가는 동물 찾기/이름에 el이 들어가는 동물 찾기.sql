-- 코드를 입력하세요
# animal_ins : animal_id, animal_type, datetime, intake_contition, name, sex_upon_intake

# 동물 이름 중, 이름에 "EL"이 들어가는 개의 아이디와 이름을 조회
select animal_id, name
from animal_ins
where 1
    and name like "%el%"
    and animal_type like "dog"
order by name;