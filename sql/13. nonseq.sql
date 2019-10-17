-- �������� ������� �ʰ� �۹�ȣ ��� ����
-- nonSeq
drop table nonSeq CASCADE CONSTRAINTS;
create table nonSeq(
    no number 
);


-- ���ۼ� -> �۹�ȣ�� ��ƾ� �Ѵ�. - �ְ� ū �۹�ȣ + 1
select max(no)  from nonSeq;
insert into nonSeq values((select max(no) + 1 from nonseq));
insert into nonSeq values(nvl((select max(no) from nonseq),0)+1);


SELECT
    *
FROM nonseq;

commit;

-- ���࿡ ��ȣ�� null�̸� ��������.
delete from nonseq where no is null;
select * from nonseq order by no desc;

-- ������ ���� : 3�� ������ - ������ 3�� ���� �����. 3���� ū ���� ��� 4 > 3, 5 > 4

-- 1. �����.
delete from nonseq where no = 3;
update nonseq set no= no - 1 where no > 3;

update nonseq set no = no + 1 where no >= 3;

select (select count(*) from nonseq)- rnum +1 viewnum, no
from(
select rownum rnum, no
from(
select *  from nonSeq order by no desc
));

-- ������ ó���� �Ǿ� �ִ� �Խ���
-- 1. ���� ������ ��������
select no, title, writer,writeDate, hit from board order by no desc;

-- 2. 1������ ������ �����Ϳ� ��ȣ�� ���δ�. rownum rnum
select rownum rnum, no, title, writer, writeDate, hit 
from(
    select no, title, writer, writeDate, hit from board
    order by no desc);

-- 3. 2�� �����Ϳ��� rnum 1~10(1������)
select rnum, no, title, writer, writeDate, hit
from(
    select rownum rnum, no, title, writer, writeDate, hit 
    from(
        select no, title, writer, writeDate, hit from board
        order by no desc))where rnum between 1 and 10;