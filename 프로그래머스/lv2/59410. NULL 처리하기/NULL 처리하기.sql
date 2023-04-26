-- 코드를 입력하세요
select ANIMAL_TYPE, ifnull(NAME, "No name") as NAME, SEX_UPON_INTAKE # 동물의 생물 종, 이름, 성별 및 중성화 여부
from ANIMAL_INS # null -> No name 표기
order by ANIMAL_ID # 아이디 순 조회