-- ���̺� ������ �ֱ�;
-- insert into table values(���̺��� ������ �ִ� ��� �����͸� ������ �°� ����);
-- �Խ��ǿ� �۾���
INSERT INTO board 
values (board_seq.nextval,'oracle','oracle jjang','kim','2019-10-10',0);

-- insert into table(�÷����) values(�����Ǿ� �ִ� �÷� ������ �°� ������ ����);
-- �Խ��ǿ� �۾��� - ����ڰ� ����, ����, �ۼ��ڸ� �Է��Ѵ�. + �۹�ȣ(pk)
insert into board(no,title, content, writer)
values(board_seq.nextval,'����Ŭ','DBMS �� �ϳ�','kim');

-- ����Ŭ�� ���� ���� TCL(commit, rollback)
commit;
-- ������ Ȯ��
select no, title,  content, writer, writeDate, hit from board;
-- sql developer �Ѱ��� ���ӿ����� �� �� �ִ�.

-- ������ �ִ� �����͸� �Ȱ��� ������ 2��� �ø��� insert�� : p 301
insert into board(no, title, content, writer, writeDate, hit)
select board_seq.nextval, title, content, writer, writeDate, hit from board;

commit;

--- �������� ����
select count(*) from board;

select count(no) from board;

-- �۹�ȣ�� 2���� ������
select * from board where no = 2;

-- �Խñ� ���� - ����, ����, �ۼ���
update board set title = '������', content = 'ū ������ ��� ó��', writer = '������'
where no = 2;
update board set title = '������', content = '���� ������ ��� ó��', writer = '������'
where no = 2;
-- �������� where ���� ������ : ��� �����Ͱ� ����ȴ�.

-- �����͸� �׸���ȣ ��������(asc), ��������(desc)���� �����ؼ� ����.
select * from board order by no asc;


-- 9�� ���� ������ : ������ ������� ������ ��� ������
DELETE from board where no = 9;



--*** �Խ����� ��ϱ� ���� ����
-- 1. ����Ʈ : �ֱٿ� �ۼ��� �ۺ���(�۹�ȣ����)
--         - �۹�ȣ, ����, �ۼ���, �ۼ���(��-��-��), ��ȸ��
select no, title, writer, writeDate, hit from board order by no desc;

-- 2. �ۺ��� : ������ Ŭ���ϸ� ��ȣ�� �´� ���� �������Ѵ�. 
select no, title, content, writer, writeDate, hit from board
where no = 2;

-- 3. �۵�� : ����, ����, �ۼ��� ����ڰ� �Է� -pK �۹�ȣ�� �ݵ�� �־���ϰ� �������� �⺻������ �Ѵ�.
insert into board(no,title,content, writer)
values(board_seq.nextval, '�ڹ�?','��ǻ�� ���','ȫ�浿');

-- 4. �ۼ��� : �۹�ȣ 2���� ����ȭ������ ������ �ؼ� �����͸� �ٽ�(�ۺ���) �����´�.
  -- ����ڴ� ����, ����, �ۼ��ڸ� ������ �� �ִ�.
update board set title = 'big data',content = 'big data', writer = 'hong'
where no = 2;
-- 5. �ۻ��� : �۹�ȣ�� 5���� �����͸� �����Ѵ�.
delete from board where no = 5;

commit;