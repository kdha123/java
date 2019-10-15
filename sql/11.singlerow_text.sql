select * from notice;

-- 문자열의 길이
select title, LENGTH(title) LENGTH, lengthb(title) lengthb
from notice;

-- 제목 출력 : 앞에 '제목:'이라고 출력
select concat('제목 : ',title) from board;
-- 제목 출력 : 앞에 '[제목:'+ 제목 + ']'이라고 출력
-- select concat('[제목 : ',title,']') from board;  -- 오류: concat()는 전달 값을 2개만 허용
select concat(concat('[제목:', title), ']') from board;
-- concat() 사용하기 어려워서 : '||' 연결 연산 사용\
select '[제목 : '||title||']' title from board;

-- 제목을 4자리만 출력
-- 제목의 길이를 0~4까지로 표시한다. ,5) 5는 포함되지 않는다.
select SUBSTR(title,0,5) from board;
-- 바이트 단위로 자르기 : 한글이 3바이트
select SUBSTRB(title,0,5) from board;
-- SUBSTR(title,시작번호) : 시작부터 마지막까지 
select SUBSTR(title,2) from board;
-- SUBSTR(title,시작위치, 가져올 글자수): 시작위치가 + 숫자 : 왼 ->오른  / - 숫자 : 오른->왼
select SUBSTR(title,-3,2) from board;

-- INSTR(원본, 찾는 글자, 시작위치,몇 번째) 
-- 시작위치와 몇번째 글자인지의 기본값은 1이다.(생략가능)
select title, INSTR(title,'ra') from board;
select title, INSTR(title, 'ra',1,1) from board;

-- 작성자를 10자리에 맞춰서 출력 -> 빈공간은 '*'로 채우자.
select LPAD(writer,10,'*') from board;
select RPAD(writer,10,'*') from board;

-- 공백문자를 지우는 trim()
select '['|| '    test    '||']' from dual;
select '['|| ltrim('    test    ')||']' from dual;
select '[' ||rtrim('       test       ') || ']' from dual;
select '[' || trim('       test       ') || ']' from dual;
-- 데이터 중에서 왼쪽에 't'를 제거하는 처리문
select '[' || ltrim('test','t') || ']' from dual;

--ROUND(숫자, 출력을 원하는 자릿수)
select ROUND(987.654,2) from dual;
select ROUND(987.654,0) from dual;
select ROUND(987.654,-1) from dual;

--TRUNC(숫자, 원하는 자릿수)
select trunc(987.654,2), TRUNC(987.654,0),trunc(987.654,-2) from dual;

--MOD() : 나머지값을 구하는 함수
--CEIL() : 주어진 숫자가 가장 가까운 큰 정수
--FLOOR() : 주어진 함수와 가장 가까운 작은 정수
select MOD(121,10), CEIL(123.45), floor(123.45) from dual;

--power(숫자1,숫자2) : 승수를 구해주는 함수
select power(2,10) from dual;
