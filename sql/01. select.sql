-- select ����

--- * : ��� �����͸� �������� - �������� �� ������� �ʴ´�.
select * from board;

--- �÷�, ... : ���ϴ� �÷��� ������ ��������
select no, title from board;

--- �÷�, ǥ����(����, ��)...
select 'board', sysdate, title from board;
-- [1] ���� -> ���ڿ� �̾���̱� ������(||)�� �̿��ؼ� �ۼ� -> �ҷ��ٰ� ����� ���� ���ؼ�
-- �̸��� ���δ�. �̶� �ٿ��� �̸��� ��Ī(Alias)�̶�� �ϰ� ��Ī�� ���ؼ� �����͸� ��������.
select '['||no||']' || title  title from board; 

-- �ۼ��ڰ� ���� �ȵɶ� � ����� ���� ����� �˾ƺ��� �ʹ�. -> ���� ����� �̸��� �ѹ��� ���
select writer from board order by writer;
select DISTINCT writer from board order by writer;

-- �Խ��� ����Ʈ �ֱ� �ۼ��� ���� ���� �ø���. : no desc ����
select no, title from board order by no desc;

-- �� ������ 10���� �����͸� ��������(513~504)
select no, title from board where no <=513 and no >= 504 order by no desc;

select no, title from board where no between 504 and 513 order by no desc;

-- 513, 510, 508, 505�� ���� ������ ��������
select no, title from board where no = 513 or no = 510 or no = 508 or no = 505
order by no desc;

-- ���� ���� ������ �ִ� �������� �����͸� �����ö� ����ϴ� or ��ſ� in
select no, title from board where no in (513, 510, 508, 505)
order by no desc;

-- �˻��� '�ڹ�'�� �����̳� ���뿡 ���ԵǾ� �ִ� ������ ��������
select no, title, content from board 
where title like '%�ڹ�%' or content like '%�ڹ�%' order by no desc;

-- where name = null (X) / where name is null <-> where name is not null (O)

--- ������ ó���� ���� select �ۼ�
-- 1. ����� �Ǵ� ��� �����͸� �����ؼ� �ҷ�����
select no, title, writer, writeDate, hit from board order by no desc;
-- 2. ���ĵ� ��� �����Ϳ� ��ȣ�� ���δ�. (rownum)
select rownum rnum, no, title, writer, writeDate, hit
from(select no, title, writer, writeDate, hit from board order by no desc);

-- 3. ������ȣ�� 1~10(�� �������� 10���� �����͸� ǥ���Ѵٰ� �ϸ�)
select rnum, no, title, writer, writeDate, hit
from(
    select rownum rnum, no, title, writer, writeDate, hit
    from(
        select no, title, writer, writeDate, hit from board order by no desc)
        )
where rnum between 1 and 10;

-- ��ü �������� ���� -> ������ Ŭ���� ���ؼ� ��ü ������ ���ؾ߸��Ѵ�.
select COUNT(*) from board;
