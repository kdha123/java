-- ȸ������  - �α��� ó�� : ���̵�, �̸�, ��޹�ȣ, ��޸� 
select id, name, grade from member;

-- ��޸� �߰� -> decode(�׸�, �񱳰�, true��, false��)
select id, name, grade,
decode(grade,1,'�Ϲ�ȸ��',decode(grade,9,'������','��޿���')) gradeName from member;

-- ����̶�� ���̺��� �����.
create table grade (
    grade number(2) primary key, 
    gradeName varchar2(15) not null
    );

insert into grade values(1,'�Ϲ�ȸ��');
insert into grade values(9,'������');
commit;

-- id, name, grade, gradeName - member,grade
select id, name, member.grade, gradeName
from member, grade where member.grade = grade.grade;