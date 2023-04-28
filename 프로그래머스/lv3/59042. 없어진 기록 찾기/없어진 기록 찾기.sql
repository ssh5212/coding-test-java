-- 코드를 입력하세요
# ANIMAL_INS
#   ANIMAL_ID, ANIMAL_TYPE, DATETIME, INTAKE_CONDITION, NAME
#   동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부

# ANIMAL_OUTS
#   ANIMAL_ID, ANIMAL_TYPE, DATETIME, NAME, SEX_UPON_OUTCOME
#   동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부
#   ANIMAL_ID (FK)

# ID와 이름 출력
# 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물
# ID 순으로 조회

# ANIMAL_INS에 없는 동물은 유실된 것임


select O.ANIMAL_ID, O.NAME
select I.NAME, O.NAME
from ANIMAL_INS I right join ANIMAL_OUTS O
    on I.NAME = O.NAME
#where I.NAME is null;

# select *
# from ANIMAL_INS 


