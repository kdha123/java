-- �������׿� �ʿ��� ���� �ۼ�
-- 1. ���� ����Ʈ : select ��ȣ �������� : ��ȣ, ����(�Ϲ� �����)
select no, title from notice order by no desc;

-- 2. ���� ��� : ����, ���� -pk ��ȣ�� �ݵ�� �Է��� �ؾ��Ѵ�. notice_seq.nextval��� -> 3�� �̻��� ��
insert into notice(no,title,content) values(notice_seq.nextval, '�����ϳ�','�Ѱ��Ϸ�');
insert into notice(no,title,content) values(notice_seq.nextval, '������','�ΰ��Ϸ�');
insert into notice(no,title,content) values(notice_seq.nextval, '������','�����Ϸ�');

-- 3. ���� ���� : ��ȣ, ����, ����, ����� : ��ϵǾ��� ���� �߿��� �ϳ��� ����
select no, title, content, startDate from notice where no = 5;

-- 4. ���� ���� : ����, ����->��ϵǾ��� ���� �߿��� �ϳ��� ����
update notice set title = '��������', content ='��������' where no = 5;

-- 5. ���� ���� : ��ϵǾ��� ���� �߿��� �ϳ��� ����
delete from notice where no = 4;

-- select * from notice;
commit;
