-- 저장 프로시저
select * from board;
-- 게시판 조회수 증가 -글번호가 입력
CREATE OR REPLACE PROCEDURE increase_hit
(v_no board.no%type)
IS
    BEGIN
    UPDATE board set hit = hit + 1
    where no = v_no;
    commit;
    END;
/

EXEC increase_hit(2);

-- 게시판 글쓰기 저장프로시저
CREATE OR REPLACE PROCEDURE writeboard
(v_title board.title%type,
v_content board.content%type,
v_writer board.writer%type)
IS
    BEGIN
    insert into board(no,title, content,writer) values(board_seq.nextval,v_title,v_content,v_writer);
    commit;
    END;
    /

EXEC writeboard('프로시저테스트','프로시저테스트','김동현');