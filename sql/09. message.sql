--- -> �����Ǿ��� �������� �����ؼ� ó���Ѵ�.
-- ���̺� ���ſ� ����
 drop table  message cascade constraints;
 
create table message(
 no number primary key,
 content varchar2(2000) not null,
 sender varchar2(20) not null references member(id),
 sendDate date default sysdate,
 accepter varchar2(20) not null references member(id),
 acceptDate date default null
 );
 -- ������ ���ſ� ����
 drop sequence message_seq;
 create sequence message_seq;
 
 -- index, view
 
-- ���õ����� : member table�� �����͸� Ȯ���ؼ� �ִ� id ���
-- �޽��� ������ : ������ �ֱ� - ������ ���, �޴� ���, �޼��� ����  
insert into message(no,content,sender,accepter)
values (message_seq.nextval,'�� ������?','admin','test');
insert into message(no,content,sender,accepter)
values (message_seq.nextval,'�� ��Ź','admin','test');
insert into message(no,content,sender,accepter)
values (message_seq.nextval,'�� ������ ����!','test','admin');
commit;

select *from message;
-- ���� �޽��� ����Ʈ(test)
select no,sender, sendDate, accepter, acceptDate from message where sender = 'test';

-- ���� �޽��� ����Ʈ(admin)
select no,sender, sendDate, accepter, acceptDate from message where accepter = 'test';
select no,sender, sendDate, accepter, acceptDate from message where sender = 'test';

-- ���� �޽��� ����Ʈ(test:���� ���� �޽���)
select no, sender, sendDate, accepter, acceptDate from message
where accepter = 'test' and acceptDate is null;

-- ���� �޽��� ����Ʈ(test:���� �޽���)
select no,sender, sendDate, accepter, acceptDate from message
where accepter = 'test' and acceptDate is not null;

-- �޽��� �б�
-- ���� �����ͷ� ó�� -> ���� ��¥�� ���� ��¥�� �ٲٱ�
update message set acceptDate = sysdate
where no = 2 and acceptDate is null;
commit;
-- ���� ������ �ҷ�����
 select no, sender, sendDate, accepter, acceptDate from message
where no = 2;

