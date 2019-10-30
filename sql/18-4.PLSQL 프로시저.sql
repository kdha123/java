-- ���� ���ν���
select * from board;
-- �Խ��� ��ȸ�� ���� -�۹�ȣ�� �Է�
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

-- �Խ��� �۾��� �������ν���
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

EXEC writeboard('���ν����׽�Ʈ','���ν����׽�Ʈ','�赿��');