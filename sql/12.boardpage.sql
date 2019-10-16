--�Խ��� ������ ó���� �Ǿ��ִ� ����Ʈ ��������
-- 1. ����� �Ǵ� ��� ������ ��������
-------------writeDate�� ����Ŭ������ date Ÿ��, �ڹٿ����� String Ÿ��
select no,title,writer,to_char(writeDate, 'yyyy-mm-dd') writeDate,hit from board order by no desc;

---2. 1������ ������ �����Ϳ� ������ȣ�� ���δ�.
select rownum rnum, no, title, writer, writeDate,hit 
from(
    select no,title,writer,to_char(writeDate, 'yyyy-mm-dd') writeDate,hit from board order by no desc
);

--3. 2���� �����Ϳ��� ���� �������� �ش�Ǵ� ������ ��������
select *
from(
    select rownum rnum, no, title, writer, writeDate, hit
    from(
        select no, title, writer, writeDate, hit from board order by no desc)
        )
where rnum between 1 and 10;
-- 2������ where rnum between 11 and 20;

--------###�������� - ������, ������ --> ���� ����, ���� ����, ���� ����
--- ���� ���� : �������� ���� ��¥�� ���� : ���� ��¥-2019-10-16, ������ : 2019-10-15
--- ���� ���� : �������� ���� ��¥����, �������� ���� ��¥ ���� - ���� ��¥�� �����ϰ� ������ ����
--- ���� ���� : �������� ���� ��¥ �ڿ� �ִ�. ���� ��¥-2019-10-16, ������ : 2019-10-20

-- ���� ���� ���õ����� �ֱ�
-- ���� ���� �Է�
insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,'9���� ����','2019-9-30 ����',
'2019-8-30','2019-9-30');
commit;
-- ���� ���� ����Ʈ
select no,title, startDate,endDate,writeDate 
from notice where endDate < TRUNC(SYSDATE);
-- ���� ���� ����Ʈ view table�� �����
create or replace view notice_old
as select no,title, startDate,endDate,writeDate from notice where endDate < TRUNC(SYSDATE);
-- view table�� �̿��� ���� ���� ����Ʈ
select no,title, startDate, endDate,writeDate from notice_old;


-- ���� ���� �Է� 
insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,'ȸ��','25�� (��) ù ȸ������',
'2019-10-07','2019-10-25');
commit;
select no,title, startDate,endDate,writeDate 
from notice
where startDate <= sysdate and endDate >= TRUNC(SYSDATE);
-- ���� ���� ����Ʈ view table�� �����
create or replace view notice_pre
as select no,title, startDate,endDate,writeDate from notice 
where startDate <= sysdate and endDate >= TRUNC(SYSDATE);
-- view table�� �̿��� ���� ���� ����Ʈ
select no,title, startDate, endDate,writeDate from notice_pre;

-- ���� ���� �Է� 
insert into notice(no,title,content,startDate,endDate) values(notice_seq.nextval,'��ź���̺�Ʈ','��ź���� ���̿��� ��������',
'2019-11-25','2019-12-30');
commit;
select no,title, startDate,endDate,writeDate 
from notice
where startDate > SYSDATE;
-- ���� ���� ����Ʈ view table�� �����
create or replace view notice_res
as select no,title, startDate,endDate,writeDate from notice
where startDate > sysdate;
-- view table�� �̿��� ���� ���� ����Ʈ
select no,title, startDate, endDate,writeDate from notice_res;
