-- �������� ����ϴ� ������ ���� ���
set SERVEROUTPUT on;


-- �Խ����� �� ���� ���� �����ٰ� ȭ�鿡 ����غ���.
DECLARE
-- ����� ���� ����
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
-- ����� ���� ���� - ���̺��� ������Ÿ���� �����ؼ� ���̺��.�÷���%TYPE
 vno board.no%TYPE;
 vwriter board.writer%TYPE;
 -- ó���� ����
 BEGIN
 select no, writer into vno, vwriter
 from board
 where no = 42 ;
 
 DBMS_OUTPUT.put_line(vno||' - '||vwriter);
 end;
 /
 
 -- %�����̸�  -> ����ڷ� ���� �����͸� �Է¹޵��� ���ش�.
 select &no  no from dual;
 
 -- �Խ��ǿ� ���ο� ���� �Է��ϴ� PL/SQL�ۼ� �����Ѵ�.
 -- ��, �����ʹ� Ű����� �Է¹޴´�. - ����, ����, �ۼ���
 DECLARE
 vtitle board.title%TYPE := '&title';
 vcontent board.content%TYPE :='&content';
 vwriter board.writer%TYPE := '&writer';
 BEGIN
 insert into board(no,title,content,writer) values(board_seq.nextval,vtitle,vcontent,vwriter);
 commit;
 end;
 /
 
 -- PL/SQL�� �̿��ؼ� �ֿܼ� ������ ��� - �Խ��� : ��ȣ,����, �ۼ���->���ڵ�
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