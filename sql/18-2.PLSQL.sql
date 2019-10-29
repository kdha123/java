-- 서버에서 출력하는 내용을 보기 허용
set SERVEROUTPUT on;

-- 게시판의 데이터를 여러개 불러와서 처리하는 프로그램
DECLARE
-- 처리문에서 사용되는 변수
v_no board.no%TYPE;
v_title board.title%TYPE;
v_writer board.writer%TYPE;
-- 데이터가 여러개 있는데 반복문을 이용해서 사용되는 커서 객체 선언
    cursor c1 IS
        select no, title, writer from board order by no desc;
BEGIN
-- 여러개의 데이터를 불러온다. - cursur오픈 
    open c1;
-- c1의 데이터가 여러개 있다. 반복문을 사용해서 꺼내는 프로그램을 작성
    LOOP
-- 커서 c1에서 부터 데이터 하나를 꺼내자 ->fetch
    FETCH c1 into v_no, v_title, v_writer;
-- 조건에 의해서 빠져나가자 exit c1%NOTFOUND -> 가져온 데이터가 발견되지 않았다.
    EXIT WHEN c1%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_no || '-'||v_title||'-'||v_writer);

    END LOOP;
    CLOSE c1;
END;
/

-- 게시판의 데이터를 여러개 불러와서 처리하는 프로그램
DECLARE
-- 데이터가 여러개 있는데 반복문을 이용해서 사용되는 커서 객체 선언
    cursor c1 IS
        select no, title, writer from board order by no desc;
BEGIN
-- 여러개의 데이터를 불러온다. - cursor 오픈 -> forEach: c1에 하나의 데이터씩 가져와서 실행
    FOR board_rec in c1 LOOP -- c1이라는 커서대신에 ()안에 select문을 작성할 수 있다.
-- 조건에 의해서 빠져나가자 exit c1%NOTFOUND -> 가져온 데이터가 발견되지 않았다.
        DBMS_OUTPUT.PUT_LINE(board_rec.no || '-'||board_rec.title||'-'||board_rec.writer);
    END LOOP;
END;
/

DECLARE
    v_writer board.writer%TYPE;
BEGIN
    select writer into v_writer
    from board;
    DBMS_OUTPUT.PUT_LINE('작성자:'||v_writer);
EXCEPTION
    WHEN TOO_MANY_ROWS THEN
    DBMS_OUTPUT.PUT_LINE('한개의 데이터만 처리할 수 있으나 여러개의 데이터를 가져옴');
END;
/

DECLARE
    new_msg EXCEPTION;
    PRAGMA EXCEPTION_INIT (new_msg, -1422);
    v_writer board.writer%TYPE;
BEGIN
    select writer into v_writer
    from board;
    DBMS_OUTPUT.PUT_LINE('작성자:'||v_writer);
EXCEPTION
    WHEN new_msg THEN
    DBMS_OUTPUT.PUT_LINE('한개의 데이터만 처리할 수 있으나 여러개의 데이터를 가져옴');
END;
/