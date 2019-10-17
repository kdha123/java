-- 시퀸스를 사용하지 않고 글번호 운영해 보기
-- nonSeq
drop table nonSeq CASCADE CONSTRAINTS;
create table nonSeq(
    no number 
);


-- 글작성 -> 글번호를 잡아야 한다. - 최고 큰 글번호 + 1
select max(no)  from nonSeq;
insert into nonSeq values((select max(no) + 1 from nonseq));
insert into nonSeq values(nvl((select max(no) from nonseq),0)+1);


SELECT
    *
FROM nonseq;

commit;

-- 만약에 번호가 null이면 삭제하자.
delete from nonseq where no is null;
select * from nonseq order by no desc;

-- 데이터 제거 : 3번 글제거 - 원래의 3번 글은 지운다. 3보다 큰 글인 경우 4 > 3, 5 > 4

-- 1. 지운다.
delete from nonseq where no = 3;
update nonseq set no= no - 1 where no > 3;

update nonseq set no = no + 1 where no >= 3;

select (select count(*) from nonseq)- rnum +1 viewnum, no
from(
select rownum rnum, no
from(
select *  from nonSeq order by no desc
));

-- 페이지 처리가 되어 있는 게시판
-- 1. 원본 데이터 가져오기
select no, title, writer,writeDate, hit from board order by no desc;

-- 2. 1번에서 가져온 데이터에 번호를 붙인다. rownum rnum
select rownum rnum, no, title, writer, writeDate, hit 
from(
    select no, title, writer, writeDate, hit from board
    order by no desc);

-- 3. 2번 데이터에서 rnum 1~10(1페이지)
select rnum, no, title, writer, writeDate, hit
from(
    select rownum rnum, no, title, writer, writeDate, hit 
    from(
        select no, title, writer, writeDate, hit from board
        order by no desc))where rnum between 1 and 10;