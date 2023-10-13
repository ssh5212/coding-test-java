# -- 코드를 입력하세요
# select round(avg(DAILY_FEE), 0) as AVERAGE_FEE # 평균 일일 대여 요금은 소수 첫 번째 자리에서 반올림
# from CAR_RENTAL_COMPANY_CAR
# where CAR_TYPE like 'SUV' # 자동차 종류가 'SUV'인 자동차들의 평균 일일 대여 요금

select round(avg(DAILY_FEE), 0) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR
where CAR_TYPE like "suv"
