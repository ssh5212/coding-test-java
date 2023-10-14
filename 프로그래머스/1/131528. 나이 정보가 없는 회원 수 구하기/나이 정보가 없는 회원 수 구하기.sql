-- 코드를 입력하세요
# select sum(AGE is null) as USERS
# from USER_INFO;

# select count(joined) as USERS
# from USER_INFO
# where AGE is null;

select count(*) as USERS
from USER_INFO
where AGE is null
