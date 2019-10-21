select * from member;

-- ȸ���� ���ڿ� ������ ����  - count
select count(*) from member
where gender = '����';
select count(*) from member
where gender = '����';
SELECT COUNT(*) FROM member;

select gender, count(*) �ο�, count(*)/(select count(*)from member)* 100 �ۼ�Ʈ from member group by gender;

-- join - �����Ͱ� ���� ���̺� (�ߺ� ����)�л�Ǿ� �ִ�. ->��ġ��.
-- �� - 1 * 5 -> 5�� : �⼮�� - �л� * ��¥ * �ð�
SELECT no, title, content, image.id,writeDate,fileName, name, gender, birth, email
from image, member;

select * from image;
insert into image values(image_seq.nextval,'��������','����������','admin',sysdate,'photo.jpg');
commit;

-- member�� id�� image id�� ���� �����͸� ����
-- inner join>> equals join
SELECT no, title, content, image.id,writeDate,fileName, name, gender, birth, email
from image, member
where image.id = member.id;

-- join ǥ��ȭ(����Ŭ ����)
select i.no, i.title, i.content, i.id, i.writeDate, i.fileName,
m.name, m.gender, m.birth, m.email
from image i, member m
where i.id = m.id;

-- join ǥ��ȭ(ANSI ����)
select i.no, i.title, i.content, i.id, i.writeDate, i.fileName,
m.name, m.gender, m.birth, m.email
from image i join member m
on i.id = m.id;

-- outter join�� ���� ������ : ȸ�������� �ý���
-- no, id, date, content, image
create table schedule(
    no number primary key,
    id varchar2(20) references member(id),
    schDate date default sysdate ,
    content varchar2(1000) not null
    );
create sequence schedule_seq;

drop table schedule;
drop sequence schedule_seq;

create table schedule_img(
    sno number primary key,
    no number references schedule(no),
    fileName varchar2(50)
);
create sequence schedule_img_seq;

-- ������
insert into schedule
values(schedule_seq.nextval,'admin',sysdate,'�����Դϴ�.');
insert into schedule
values(schedule_seq.nextval, 'admin', sysdate, '�߰������Դϴ�.');
commit;

select*from schedule;

-- 2�� �߰������� �̹��� �߰��ϱ�
insert into schedule_img values(schedule_img_seq.nextval, 2, 's1.jpg');

-- �̹����� �ִ�(schedule_img ���̺�) �����ʹ� ���´�.
-- schedule_img�� �����Ͱ� ���� ��� equals ������ �Ұ��ϴ�.(������ �� ������)
select s.no,s.schDate,s.content,i.fileName from schedule s, schedule_img i
where s.no = i.no;
-- ������ 3���� �� ���;��Ѵ�. ������ �����Ͱ� ������ �����ʹ� ����� �Ǿ���Ѵ�.
select s.no,s.schDate,s.content,i.fileName from schedule s, schedule_img i
where s.no = i.no(+);
