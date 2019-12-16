 -- 트리거(TRiGGER)
 -- 주문테이블 작성
 create table t_order(
    no number primary key,
    title varchar2(50) not null,
    writeDate date default sysdate
    );
    
-- 주문 번호에 사용할 시퀸스 등록
create sequence t_order_seq;

-- 주문 시간에 대한 DB에서의 처리 -> 트리거
CREATE OR REPLACE TRIGGER t_order_tr
-- 트리거가 동작할 타이밍 : t_order 테이블에 데이터가 insert 되기 전
-- before : 실행 전
-- after : 실행 후
-- event(동작 - 데이터의 변경) -> insert, update, delete
BEFORE INSERT ON t_order
BEGIN
    IF(to_char(SYSDATE, 'HH24:MI') NOT BETWEEN '12:40' AND '18:50') THEN
        RAISE_APPLICATION_ERROR(-20100, '주문 시간이 아닙니다.');
    END IF;
END;
/

INSERT INTO t_order(no, title) values(t_order_seq.nextval,'맨투맨 티셔츠');
commit;

-- 댓글 : 게시판에 댓글 : 개시판에 댓글의 갯수를 저장하는 컬럼

-- 게시판 댓글 테이블
drop table board_rep;
create table board_rep(
    rno number primary key,
    no number references board(no),
    content varchar2(1000) not null,
    writer varchar2(30) not null,
    writeDate date default sysdate
    );
create sequence board_rep_seq;

select*from board;


-- 리스트에서 나타난 글번호 2번 글의 댓글 달기
insert into board_rep(rno, no, content,writer)
values(board_rep_seq.nextval, 2,'오라클 좋아요~~','홍길동');
commit;

-- 게시판 리스트를 출력
-- 글번호, 제목, 작성자, 작성일, 조회수, 댓글개수
select no, title, writer, writeDate, hit, (select count(*) from board_rep where board.no = board_rep.no) rep_cnt
from board order by no desc;

-- 서브쿼리를 이용해서 데이터 카운트를 받아와서 처리를 하면 게시글 한개마다 모든 댓글을 구한다.
-- 느려지므로 해결 방법으로 게시판에 댓글카운트 컬럼을 더 만들어서 운영한다.
alter table board 
ADD (rep_cnt number default 0);

desc board;

-- rep_cnt에 초기값 처리를 반드시 해주어야한다.
update board b set rep_cnt = (select count(*)from board_rep br where b.no = br.no); 
commit;

-- 댓글의 리스트 출력하기 -> 게시판 글보기
-- 게시판의 글은 1개(글번호에 맞는)의 데이터를 가져와서 출력한다.
-- 2번글 보기
select no,title,content,writer,writeDate,hit from board where no = 2;
--이어서 2번글에 대한 댓글을 가져와서 출력한다.
select rno, no, content, writer, writeDate from board_rep 
where no = 2 order by rno desc;

--- 댓글 쓰기
insert into board_rep(rno, no, content, writer)
values(board_rep_seq.nextval,2,'오라클 짱짱','kim');
update board b set rep_cnt = rep_cnt + 1 where no = 2;
commit;

-- req_cnt 컬럽을 이용한 리스트
select no, title, writer, writeDate, hit, rep_cnt
from board
order by no desc;

create or replace TRIGGER board_rep_insert_tr

AFTER INSERT ON board_rep
for each row
begin
    update board set rep_cnt = rep_cnt +1
    where no = :new.no;
    END;
/