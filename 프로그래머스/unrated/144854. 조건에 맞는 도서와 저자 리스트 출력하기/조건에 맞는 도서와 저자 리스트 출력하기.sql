-- 코드를 입력하세요
# book
# book_id	category	author_id	price	published_date

# AUTHOR 
# author_id	author_name

# select *
# from AUTHOR ;

select B.BOOK_ID, A.AUTHOR_NAME, date_format(B.PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
from BOOK B join AUTHOR A
    on B.AUTHOR_ID = A.AUTHOR_ID
where 1
    and B.CATEGORY like "경제"
order by PUBLISHED_DATE asc;