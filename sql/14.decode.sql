-- 회원관리  - 로그인 처리 : 아이디, 이름, 등급번호, 등급명 
select id, name, grade from member;

-- 등급명 추가 -> decode(항목, 비교값, true값, false값)
select id, name, grade,
decode(grade,1,'일반회원',decode(grade,9,'관리자','등급오류')) gradeName from member;

-- 등급이라는 테이블을 만든다.
create table grade (
    grade number(2) primary key, 
    gradeName varchar2(15) not null
    );