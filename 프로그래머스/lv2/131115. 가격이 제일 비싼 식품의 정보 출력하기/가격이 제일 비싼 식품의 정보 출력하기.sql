-- 코드를 입력하세요

select PRODUCT_ID, PRODUCT_NAME, PRODUCT_CD, CATEGORY, PRICE
from FOOD_PRODUCT 
where price = 
    (select max(PRICE)
    from FOOD_PRODUCT)