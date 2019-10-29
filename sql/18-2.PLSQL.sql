-- �������� ����ϴ� ������ ���� ���
set SERVEROUTPUT on;

-- �Խ����� �����͸� ������ �ҷ��ͼ� ó���ϴ� ���α׷�
DECLARE
-- ó�������� ���Ǵ� ����
v_no board.no%TYPE;
v_title board.title%TYPE;
v_writer board.writer%TYPE;
-- �����Ͱ� ������ �ִµ� �ݺ����� �̿��ؼ� ���Ǵ� Ŀ�� ��ü ����
    cursor c1 IS
        select no, title, writer from board order by no desc;
BEGIN
-- �������� �����͸� �ҷ��´�. - cursur���� 
    open c1;
-- c1�� �����Ͱ� ������ �ִ�. �ݺ����� ����ؼ� ������ ���α׷��� �ۼ�
    LOOP
-- Ŀ�� c1���� ���� ������ �ϳ��� ������ ->fetch
    FETCH c1 into v_no, v_title, v_writer;
-- ���ǿ� ���ؼ� ���������� exit c1%NOTFOUND -> ������ �����Ͱ� �߰ߵ��� �ʾҴ�.
    EXIT WHEN c1%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(v_no || '-'||v_title||'-'||v_writer);

    END LOOP;
    CLOSE c1;
END;
/

-- �Խ����� �����͸� ������ �ҷ��ͼ� ó���ϴ� ���α׷�
DECLARE
-- �����Ͱ� ������ �ִµ� �ݺ����� �̿��ؼ� ���Ǵ� Ŀ�� ��ü ����
    cursor c1 IS
        select no, title, writer from board order by no desc;
BEGIN
-- �������� �����͸� �ҷ��´�. - cursor ���� -> forEach: c1�� �ϳ��� �����;� �����ͼ� ����
    FOR board_rec in c1 LOOP -- c1�̶�� Ŀ����ſ� ()�ȿ� select���� �ۼ��� �� �ִ�.
-- ���ǿ� ���ؼ� ���������� exit c1%NOTFOUND -> ������ �����Ͱ� �߰ߵ��� �ʾҴ�.
        DBMS_OUTPUT.PUT_LINE(board_rec.no || '-'||board_rec.title||'-'||board_rec.writer);
    END LOOP;
END;
/

DECLARE
    v_writer board.writer%TYPE;
BEGIN
    select writer into v_writer
    from board;
    DBMS_OUTPUT.PUT_LINE('�ۼ���:'||v_writer);
EXCEPTION
    WHEN TOO_MANY_ROWS THEN
    DBMS_OUTPUT.PUT_LINE('�Ѱ��� �����͸� ó���� �� ������ �������� �����͸� ������');
END;
/

DECLARE
    new_msg EXCEPTION;
    PRAGMA EXCEPTION_INIT (new_msg, -1422);
    v_writer board.writer%TYPE;
BEGIN
    select writer into v_writer
    from board;
    DBMS_OUTPUT.PUT_LINE('�ۼ���:'||v_writer);
EXCEPTION
    WHEN new_msg THEN
    DBMS_OUTPUT.PUT_LINE('�Ѱ��� �����͸� ó���� �� ������ �������� �����͸� ������');
END;
/