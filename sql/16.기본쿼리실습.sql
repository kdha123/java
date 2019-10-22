--- �Խ��� �⺻ ����
-- 1. list -> ������� -> rownum�߰� -> ������ ������(1~10������)
select *
from(
    select rownum rnum, no, title, writer, writeDate,hit
    from (
        select no, title, writer, writeDate, hit
        from board
        order by no desc
))where rnum between 1 and 10;

--2. write
insert into board(no,title, content, writer) values(board_seq.nextval,'title','content','kim');
commit;

--3. view
update board set hit = hit + 1
where no = 2;
commit;
select no,title, content, writer, writeDate, hit from board where no = 2;

--4. update
update board set title = 'big', content = 'bigdata', writer = 'kim'
where no = 2;
commit;

--5. delete
delete from board where no = 21;
commit;

-- message �⺻����
-- 1.list
select ms.no, ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, ms.acceptDate
from message ms, member sm, member am
where ms.sender = sm.id and ms.accepter = am.id;

-- 2. view 
-- 2-1. ���� ����� �޼����� Ȯ���� �� 1���޼��� ����(admin�� ���´�.)
select no ,ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, ms.acceptDate
from message ms, member sm, member am
where ms.no = 1 and ms.sender = sm.id and ms.accepter = am.id;

-- 2-2. �޴� ����� �޼����� Ȯ���� ��(accepter�� test�� ���)
update message set acceptDate = sysdate
where no = 1 and acceptDate is null;
commit;
select no ,ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, ms.acceptDate
from message ms, member sm, member am
where ms.no = 1 and ms.sender = sm.id and ms.accepter = am.id;

-- 3. write
insert into message(no, content, sender,accepter) values(message_seq.nextval, '�������ϴ�.','test','admin');
commit;

-- 4. update - ��������� �޴»���� Ȯ���� ���� ���� ��츸 ������ �����ϴ�.
update message set content = '�ſ� �������ϴ�.' where no = 21 and acceptDate is null;
commit;

-- 5. delete - ������� : ��������� ���� �ʴ� ��츸 ���� ����(����)
-- ���� ����� ���� �޽����� ������ �� �ִ�.
delete from message where no = 3 and acceptDate is null;
commit;

-- �̹��� �Խ��� �⺻����
-- 1. list
select i.no, i.title, i.content, m.name,i .id, i.writeDate, i.fileName 
from member m, image i
where m.id = i.id;

-- 2. view
select i.no, i.title, i.content, m.name,i.id, i.writeDate, i.fileName 
from member m, image i
where m.id = i.id and i.no = 1;

-- 3. write
insert into image(no,title, content,id,fileName) 
values(image_seq.nextval,'���� ���� ����','�������� ���� ����','test','very good photo.jpg');
commit;

-- 4. update
update image set title = '���� ���� ����', content = '��¥ ���� ����', writeDate = sysdate, fileName = 'goodphoto.jpg' where no = 1;
commit;

-- 5. delete
delete from image where no = 21;
commit;