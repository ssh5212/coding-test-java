-- 코드를 입력하세요
# product : product_id, product_code, price

# 상품 카테고리 코드별 상품 개수 출력
select substr(product_code, 1, 2) as category, count(*) as products
from product
group by category
order by category;