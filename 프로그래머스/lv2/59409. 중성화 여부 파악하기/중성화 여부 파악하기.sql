-- 코드를 입력하세요
# animal_ins : animal_id, animal_type, datetime, intake_condition, name, sex_upon_intake

# 동물의 중성화 여부
select animal_id, name, 
    case
        when (sex_upon_intake like "%Neutered%" or sex_upon_intake like "%Spayed%") then "O"
        else "X"
    end
        
sex_upon_intake
from animal_ins
order by animal_id;
