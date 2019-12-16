 -- Ʈ����(TRiGGER)
 -- �ֹ����̺� �ۼ�
 create table t_order(
    no number primary key,
    title varchar2(50) not null,
    writeDate date default sysdate
    );
    
-- �ֹ� ��ȣ�� ����� ������ ���
create sequence t_order_seq;

-- �ֹ� �ð��� ���� DB������ ó�� -> Ʈ����
CREATE OR REPLACE TRIGGER t_order_tr
-- Ʈ���Ű� ������ Ÿ�̹� : t_order ���̺� �����Ͱ� insert �Ǳ� ��
-- before : ���� ��
-- after : ���� ��
-- event(���� - �������� ����) -> insert, update, delete
BEFORE INSERT ON t_order
BEGIN
    IF(to_char(SYSDATE, 'HH24:MI') NOT BETWEEN '12:40' AND '18:50') THEN
        RAISE_APPLICATION_ERROR(-20100, '�ֹ� �ð��� �ƴմϴ�.');
    END IF;
END;
/

INSERT INTO t_order(no, title) values(t_order_seq.nextval,'������ Ƽ����');
commit;

-- ��� : �Խ��ǿ� ��� : �����ǿ� ����� ������ �����ϴ� �÷�

-- �Խ��� ��� ���̺�
drop table board_rep;
create table board_rep(
    rno number primary key,
    no number references board(no),
    content varchar2(1000) not null,
    writer varchar2(30) not null,
    writeDate date default sysdate
    );
create sequence board_rep_seq;

select*from board;


-- ����Ʈ���� ��Ÿ�� �۹�ȣ 2�� ���� ��� �ޱ�
insert into board_rep(rno, no, content,writer)
values(board_rep_seq.nextval, 2,'����Ŭ ���ƿ�~~','ȫ�浿');
commit;

-- �Խ��� ����Ʈ�� ���
-- �۹�ȣ, ����, �ۼ���, �ۼ���, ��ȸ��, ��۰���
select no, title, writer, writeDate, hit, (select count(*) from board_rep where board.no = board_rep.no) rep_cnt
from board order by no desc;

-- ���������� �̿��ؼ� ������ ī��Ʈ�� �޾ƿͼ� ó���� �ϸ� �Խñ� �Ѱ����� ��� ����� ���Ѵ�.
-- �������Ƿ� �ذ� ������� �Խ��ǿ� ���ī��Ʈ �÷��� �� ���� ��Ѵ�.
alter table board 
ADD (rep_cnt number default 0);

desc board;

-- rep_cnt�� �ʱⰪ ó���� �ݵ�� ���־���Ѵ�.
update board b set rep_cnt = (select count(*)from board_rep br where b.no = br.no); 
commit;

-- ����� ����Ʈ ����ϱ� -> �Խ��� �ۺ���
-- �Խ����� ���� 1��(�۹�ȣ�� �´�)�� �����͸� �����ͼ� ����Ѵ�.
-- 2���� ����
select no,title,content,writer,writeDate,hit from board where no = 2;
--�̾ 2���ۿ� ���� ����� �����ͼ� ����Ѵ�.
select rno, no, content, writer, writeDate from board_rep 
where no = 2 order by rno desc;

--- ��� ����
insert into board_rep(rno, no, content, writer)
values(board_rep_seq.nextval,2,'����Ŭ ¯¯','kim');
update board b set rep_cnt = rep_cnt + 1 where no = 2;
commit;

-- req_cnt �÷��� �̿��� ����Ʈ
select no, title, writer, writeDate, hit, rep_cnt
from board
order by no desc;

create or replace TRIGGER board_rep_insert_tr

AFTER INSERT ON board_rep
for each row
begin
    update board set rep_cnt = rep_cnt +1
    where no = :new.no;
    END;
/