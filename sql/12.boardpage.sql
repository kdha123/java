--게시판 페이지 처리가 되어있는 리스트 가져오기
-- 1. 대상이 되는 모든 데이터 가져오기
-------------writeDate가 오라클에서는 date 타입, 자바에서는 String 타입
select no,title,writer,to_char(writeDate, 'yyyy-mm-dd') writeDate,hit from board order by no desc;

---2. 1번에서 가져온 데이터에 순서번호를 붙인다.
select rownum rnum, no, title, writer, writeDate,hit 
from(
    select no,title,writer,to_char(writeDate, 'yyyy-mm-dd') writeDate,hit from board order by no desc
);

--3. 2번의 데이터에서 현재 페이지에 해당되는 데이터 가져오기
select *
from(
    select rownum rnum, no, title, writer, writeDate, hit
    from(
        select no, title, writer, writeDate, hit from board order by no desc)
        )
where rnum between 1 and 10;
-- 2페이지 where rnum between 11 and 20;

--------###공지사항 - 시작일, 종료일 --> 지난 공지, 현재 공지, 예약 공지
--- 지난 공지 : 종료일이 현재 날짜의 이전 : 현재 날짜-2019-10-16, 종료일 : 2019-10-15
--- 현재 공지 : 시작일이 현재 날짜이전, 종료일이 현재 날짜 이후 - 현재 날짜가 시작일과 종료일 사이
--- 예약 공지 : 시작일이 현재 날짜 뒤에 있다. 현재 날짜-2019-10-16, 시작일 : 2019-10-20

-- 공지 사항 샘플데이터 넣기
-- 지난 공지 입력
insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,'9월반 개강','2019-9-30 개강',
'2019-8-30','2019-9-30');
commit;
-- 지난 공지 리스트
select no,title, startDate,endDate,writeDate 
from notice where endDate < TRUNC(SYSDATE);
-- 지난 공지 리스트 view table로 만들기
create or replace view notice_old
as select no,title, startDate,endDate,writeDate from notice where endDate < TRUNC(SYSDATE);
-- view table을 이용한 지난 공지 리스트
select no,title, startDate, endDate,writeDate from notice_old;


-- 현재 공지 입력 
insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,'회식','25일 (금) 첫 회식진행',
'2019-10-07','2019-10-25');
commit;
select no,title, startDate,endDate,writeDate 
from notice
where startDate <= sysdate and endDate >= TRUNC(SYSDATE);
-- 현재 공지 리스트 view table로 만들기
create or replace view notice_pre
as select no,title, startDate,endDate,writeDate from notice 
where startDate <= sysdate and endDate >= TRUNC(SYSDATE);
-- view table을 이용한 현재 공지 리스트
select no,title, startDate, endDate,writeDate from notice_pre;

-- 예약 공지 입력 
insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,'성탄절이벤트','성탄절에 눈이오면 선물증정',
'2019-11-25','2019-12-30');
commit;
select no,title, startDate,endDate,writeDate 
from notice
where startDate > SYSDATE;
-- 예약 공지 리스트 view table로 만들기
create or replace view notice_res
as select no,title, startDate,endDate,writeDate from notice
where startDate > sysdate;
-- view table을 이용한 예약 공지 리스트
select no,title, startDate, endDate,writeDate from notice_res;
