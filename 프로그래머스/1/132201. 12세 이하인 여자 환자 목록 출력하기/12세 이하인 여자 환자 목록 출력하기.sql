# -- 코드를 입력하세요
# SELECT PT_NAME, PT_NO, GEND_CD, AGE, IFNULL(TLNO, 'NONE') as TLNO 
# from PATIENT
# where age <= 12
#     and GEND_CD ='W'
# order by AGE desc, PT_NAME asc;

select PT_NAME, PT_NO, GEND_CD, AGE, ifnull(TLNO, 'NONE') as TLNO
from PATIENT 
where 1
	and age <= 12
	and GEND_CD = 'W'
order by age desc, PT_NAME asc
