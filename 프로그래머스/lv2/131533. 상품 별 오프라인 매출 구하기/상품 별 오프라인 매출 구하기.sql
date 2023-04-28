-- 코드를 입력하세요
# PRODUCT
#   PRODUCT_ID, PRODUCT_CODE, PRICE
#   상품 ID, 상품코드, 판매가

# OFFLINE_SALE
#   OFFLINE_SALE_ID, PRODUCT_ID, SALES_AMOUNT, SALES_DATE
#   오프라인 상품 판매 ID, 상품 ID, 판매량, 판매일

# select *
# from PRODUCT P inner join OFFLINE_SALE O
# on P.PRODUCT_ID


select p.PRODUCT_CODE, sum(p.price * o.SALES_AMOUNT) as sales
from product p join (select PRODUCT_ID, SALES_AMOUNT
                    from OFFLINE_SALE ) o
    on p.PRODUCT_ID	= o.PRODUCT_ID
group by o.PRODUCT_ID
order by sales desc, p.PRODUCT_CODE asc

# select *
# from OFFLINE_SALE
# where SALES_AMOUNT = 1



# 상품코드 별 매출액(판매가 * 판매량) 합계
# 매출액을 기준으로 내림차순 정렬 / 매출액이 같다면 상품코드를 기준으로 오름차순 정렬