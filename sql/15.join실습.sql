-- ȸ��
-- ���
select * from grade;

select* from member;

-- �α��� ó�� : ���̵�, �̸�, ���, ��޸� -> member,grade 2���� ���̺��� �����´� >>join
-- from t,t where() and (���� ����) -> Oracle join
select m.id, m.name, m.grade, g.gradeName from member m, grade g
where m.grade = g.grade;

-- �̹��� ���� ǥ�� - ��ȣ, ����, ����, �ۼ��ھ��̵�, �ۼ����̸�, �ۼ���, ���ϸ�
select i.no, i.title, i.content, m.name,i .id, i.writeDate, i.fileName from member m, image i
where m.id = i.id;

-- �����亯 - ��ȣ, ����, �ۼ��� ���̵�, �ۼ��� �̸�, ���ñ۹�ȣ, ������ȣ, �鿩�����ȣ
select q.no, q.title, q.id, m.name, q.refNo, q.ordNo, q.levNo
from qna q, member m
where q.id = m.id
order by refNo desc, ordNo asc;

-- �޽��� - ��ȣ, ����, ����������̵�, ��������̸�, ������¥, �޴»�� ���̵�, �޴»���̸�
--- ������¥
select * from message;
select ms.no, ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, acceptDate
from message ms, member sm, member am 
where ms.accepter = am.id and ms.sender = sm.id;

