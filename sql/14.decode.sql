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