-- �α��� ó���� ���� ����
select m.id, m.name, g.gradeName, m.grade from member m, grade g
-- ����ڿ��� ���� ���̵�� ��й�ȣ �����͸� �ٲٱ� ���� 'test'-->?, '1111'-->?
where (id = 'test' and pw = '1111')and(m.grade = g.grade);