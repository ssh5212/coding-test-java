# -- 코드를 입력하세요
# select ANIMAL_ID
# from ANIMAL_INS # 동물 보호소 동물 데이터
# where NAME is null # 이름이 없는 채로 들어온 동물
# order by ANIMAL_ID # ID 오름차순 정렬

select ANIMAL_ID
from ANIMAL_INS 
where name is null
order by ANIMAL_ID asc