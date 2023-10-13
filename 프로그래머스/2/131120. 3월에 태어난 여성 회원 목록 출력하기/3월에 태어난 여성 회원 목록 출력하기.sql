# -- 코드를 입력하세요
# SELECT MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, '%Y-%m-%d') as DATE_OF_BIRTH
# from MEMBER_PROFILE
# where TLNO is not null 
#     and month(DATE_OF_BIRTH) = 3 
#     and gender = 'w'
# order by member_id asc;

select MEMBER_ID, MEMBER_NAME, GENDER, date_format(DATE_OF_BIRTH, "%Y-%m-%d") as DATE_OF_BIRTH
from MEMBER_PROFILE
where 1
	and month(DATE_OF_BIRTH) = 3
	and GENDER = "W"
	and TLNO is not null
order by MEMBER_ID asc