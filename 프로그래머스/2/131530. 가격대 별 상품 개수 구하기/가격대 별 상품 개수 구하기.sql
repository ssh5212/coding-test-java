-- 코드를 입력하세요
# product : product_id, product_code, price

# 만원 단위의 가격대 별로 상품 개수를 출력 (0, 10000, 20000, ..)
# 가격대 기준으로 오름차순 정렬



select truncate(price, -4) as price_group, count(product_id)
from product
group by price_group
order by price_group asc;