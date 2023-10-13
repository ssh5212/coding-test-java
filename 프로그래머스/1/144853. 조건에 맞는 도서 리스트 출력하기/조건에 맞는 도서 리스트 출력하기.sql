# -- 코드를 입력하세요
# SELECT book_id, date_format(published_date, '%Y-%m-%d') as PUBLISHED_DATE
# from book
# where category = "인문" and year(published_date) = 2021
# order by published_date asc;

select BOOK_ID, date_format(PUBLISHED_DATE, "%Y-%m-%d") as PUBLISHED_DATE
from BOOK 
where PUBLISHED_DATE like "2021%" and category = "인문"
order by PUBLISHED_DATE asc