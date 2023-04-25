-- 코드를 입력하세요
select FOOD_TYPE, REST_ID, REST_NAME, max(FAVORITES) as FAVORITES
from rest_info
where FOOD_TYPE='일식'  || FOOD_TYPE='중식' || FOOD_TYPE='한식'
order by FAVORITES desc

# select *
# from rest_info