-- 서버에서 출력하는 내용을 보기 허용
set SERVEROUTPUT on;


-- 게시판의 한 개의 글을 가져다가 화면에 출력해보자.
DECLARE
-- 사용할 변수 선언
 vno number;
 vwriter varchar2(30);
 BEGIN
 select no, writer into vno, vwriter
 from board
 where no = 42 ;
 
 DBMS_OUTPUT.put_line(vno||' - '||vwriter);
 end;
 /
 select * from board;
 
 DECLARE
-- 사용할 변수 선언 - 테이블의 데이터타입을 지정해서 테이블명.컬럼명%TYPE
 vno board.no%TYPE;
 vwriter board.writer%TYPE;
 -- 처리문 선언
 BEGIN
 select no, writer into vno, vwriter
 from board
 where no = 42 ;
 
 DBMS_OUTPUT.put_line(vno||' - '||vwriter);
 end;
 /
 
 -- %변수이름  -> 사용자로 부터 데이터를 입력받도록 해준다.
 select &no  no from dual;
 
 -- 게시판에 새로운 글을 입력하는 PL/SQL작성 실행한다.
 -- 단, 데이터는 키보드로 입력받는다. - 제목, 내용, 작성자
 DECLARE
 vtitle board.title%TYPE := '&title';
 vcontent board.content%TYPE :='&content';
 vwriter board.writer%TYPE := '&writer';
 BEGIN
 insert into board(no,title,content,writer) values(board_seq.nextval,vtitle,vcontent,vwriter);
 commit;
 end;
 /
 
 -- PL/SQL을 이용해서 콘솔에 데이터 출력 - 게시판 : 번호,제목, 작성자->레코드
 DECLARE
  TYPE board_record_type IS RECORD (
  no board.no%TYPE,
  title board.title%TYPE,
  writer board.writer%TYPE
  );
  v_rec1 board_record_type;
 BEGIN
 select no,title,writer into v_rec1
 from board where no = 61;
 
  DBMS_OUTPUT.put_line(v_rec1.no||' - '||v_rec1.title||' - '||v_rec1.writer);
 END;
 /