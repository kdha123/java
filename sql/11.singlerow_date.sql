-- 책을 대여하려고한다. 그래서 오늘로부터 7일 이후 날짜(+7)를 계산.
select sysdate + 7 from dual;

-- 성탄절에서 오늘 날짜를 빼보자.
-- to_date(데이트 형식에 맞는 문자열)-> 날짜형으로 변환
-- 두 개의 날짜를 빼면 날짜 사이의 일수가 나온다. -> 소수점이하는 시간을 의미한다.
select to_date('2019-12-25') - sysdate from dual;

-- 데이터를 오늘 날짜까지 표시해야만한다.
select 'data' from dual
where to_date('2019-10-15') >= sysdate;
-- sysdate는 날짜와 시간을 가지고 있다. 그런데 오늘 '2019-10-15 00:00:00'
-- 제대로 처리를 하려면 오늘 날짜의 시간을 버려야한다.
-- trunc으로 해결
select 'data' from dual
where to_date('2019-10-15') >= trunc(sysdate);
-- where to_date('2019-10-15') + 1 >= sysdate;

-- 이달의 마지막날 계산
select last_day(sysdate) from dual;
select to_date('2019-11-1')-1 from dual;

-- 날짜형식을 원하는 형식에 맞게 문자열로 만들기
select to_char(sysdate,'yyyy-mm-dd  hh24:mi:ss') today from dual;