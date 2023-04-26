-- 코드를 입력하세요
select ANIMAL_ID # ID 조회
from ANIMAL_INS # 동물 보호소 동물 테이블
where NAME is not null # 이름이 있는 동물
order by ANIMAL_ID # ID 오름차순 출력