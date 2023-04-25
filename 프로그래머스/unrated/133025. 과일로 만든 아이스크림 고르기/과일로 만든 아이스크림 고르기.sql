# FIRST_HALF : 출하 번호, 아이스크림 맛, 상반기 아이스크림 총주문량
# ICECREAM_INFO : 아이스크림 맛, 아이스크림의 성분 타입을
-- 코드를 입력하세요
SELECT fh.flavor
from FIRST_HALF fh inner join ICECREAM_INFO ii
on fh.FLAVOR = ii.FLAVOR
where 
    INGREDIENT_TYPE = 'fruit_based'
    and total_order >= 3000
    
order by TOTAL_ORDER desc;

