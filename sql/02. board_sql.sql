-- 테이블에 데이터 넣기;
-- insert into table values(테이블이 가지고 있는 모든 데이터를 순서에 맞게 나열);
-- 게시판에 글쓰기
INSERT INTO board 
values (board_seq.nextval,'oracle','oracle jjang','kim','2019-10-10',0);

-- insert into table(컬럼명들) values(나열되어 있는 컬럼 순서에 맞게 데이터 나열);
-- 게시판에 글쓰기 - 사용자가 제목, 내용, 작성자를 입력한다. + 글번호(pk)
insert into board(no,title, content, writer)
values(board_seq.nextval,'오라클','DBMS 중 하나','kim');

-- 오라클에 완전 적용 TCL(commit, rollback)
commit;
-- 데이터 확인
select no, title,  content, writer, writeDate, hit from board;
-- sql developer 한개의 접속에서는 볼 수 있다.

-- 가지고 있는 데이터를 똑같은 데이터 2배로 늘리는 insert문 : p 301
insert into board(no, title, content, writer, writeDate, hit)
select board_seq.nextval, title, content, writer, writeDate, hit from board;

commit;

--- 데이터의 갯수
select count(*) from board;

select count(no) from board;

-- 글번호가 2번인 데이터
select * from board where no = 2;

-- 게시글 수정 - 제목, 내용, 작성자
update board set title = '빅데이터', content = '큰 데이터 덩어리 처리', writer = '관리자'
where no = 2;
update board set title = '빅데이터', content = '많은 데이터 덩어리 처리', writer = '관리자'
where no = 2;
-- 수정에서 where 문이 없으면 : 모든 데이터가 변경된다.

-- 데이터를 그르번호 오름차순(asc), 내림차순(desc)으로 정렬해서 보자.
select * from board order by no asc;


-- 9번 글을 지우자 : 조건을 사용하지 않으면 모두 지워짐
DELETE from board where no = 9;



--*** 게시판을 운영하기 위한 쿼리
-- 1. 리스트 : 최근에 작성한 글부터(글번호역순)
--         - 글번호, 제목, 작성자, 작성일(년-월-일), 조회수
select no, title, writer, writeDate, hit from board order by no desc;

-- 2. 글보기 : 제목을 클릭하면 번호에 맞는 글이 보여야한다. 
select no, title, content, writer, writeDate, hit from board
where no = 2;

-- 3. 글등록 : 제목, 내용, 작성자 사용자가 입력 -pK 글번호는 반드시 있어야하고 나머지는 기본값으로 한다.
insert into board(no,title,content, writer)
values(board_seq.nextval, '자바?','컴퓨터 언어','홍길동');

-- 4. 글수정 : 글번호 2번만 수정화면으로 전달을 해서 데이터를 다시(글보기) 가져온다.
  -- 사용자는 제목, 내용, 작성자를 수정할 수 있다.
update board set title = 'big data',content = 'big data', writer = 'hong'
where no = 2;
-- 5. 글삭제 : 글번호가 5번인 데이터를 삭제한다.
delete from board where no = 5;

commit;