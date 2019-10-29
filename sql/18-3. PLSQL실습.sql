-- PL/SQL Ȱ���Ͽ� ���� ����� �����Ͻÿ�.
--1. �������� ����Ʈ ���
--2. �������� ���� ���(����Ʈ ��µ� ���� �� �ϳ�)
--3. �������� ���
--4. �������� ����(����Ʈ ��µ� ���� �� �ϳ�)
-- DECLARE, BEGIN, END;/ �������� ó��
-- Ʈ����, �������ν���, �����췯 ����

-- ����Ʈ���
DECLARE
 vno notice.no%TYPE;
 vtitle notice.title%TYPE;
 vcontent notice.content%TYPE;
    cursor c1 is 
        select no, title, content from notice order by no desc;
BEGIN
 open c1;
    LOOP
    FETCH c1 INTO vno, vtitle, vcontent;
    EXIT WHEN c1%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
    END LOOP;
close c1;
END;
/

-- �������
DECLARE
 vno notice.no%TYPE;
 vtitle notice.title%TYPE;
 vcontent notice.content%TYPE;
 BEGIN
 select no,title, content into vno, vtitle, vcontent from notice
 where no = 22;
 DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
 END;
 /

--��� ���
DECLARE
vno notice.no%TYPE;
vtitle notice.title%TYPE := '&title';
vcontent notice.content%TYPE := '&content';
BEGIN
insert into notice(no,title,content) values(notice_seq.nextval,vtitle,vcontent);
DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
commit;
END;
/

--4. �������� ����(����Ʈ ��µ� ���� �� �ϳ�)
DECLARE
vno notice.no%TYPE;
vtitle notice.title%TYPE;
vcontent notice.content%TYPE;
BEGIN
delete from notice where no = 61;
DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
END;
/
 