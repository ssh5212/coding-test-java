-- 코드를 입력하세요
# animal_ins : animal_id, animal_type, datetime, intake_condition, name, sex_upon_intake

# 이름이 Lucy, Ella, Pickle, Rogan, Sabrina, Mitty인 동물의 아이디와 이름, 성별 및 중성화 여부를 조회
select ANIMAL_ID, NAME, SEX_UPON_INTAKE
from animal_ins
where NAME in ("Lucy", "Ella", "Pickle", "Rogan", "Sabrina", "Mitty")