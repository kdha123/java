-- �����亯 ��� �ʿ��� ���� �ۼ�
-- 1. ����Ʈ
select no,title,content,id,writeDate,hit from qna;
-- 2. ���� - ��ȸ�� : 1���� ���� ��Ų��(update)
update qna set hit = hit + 1 where no = 2;
select no, title, content,id, writeDate,hit from qna where no = 2;
commit;
-- 3. ���
insert into qna(no,id,title,content) values(notice_seq.nextval,'sons','����','�����亯');
commit;
-- 4. ����
update  qna set title = '�����̿�', content ='�̰Թ���' where no = 1;
commit;
-- 5. ����
delete from qna where no = 3;
commit;

-- **���� Ű�� ��ϵǾ� �ִ� ��� �θ�Ű�� �����Ǹ� �ڽ�Ű�� �����͸�
--   ��� �� ������ ���� �������� ����ؼ� ���� -> ������ �θ�Ű�� �����ͻ����Ұ�
-- *** ȸ������ - ���� �� �� �߰�
-- 6. �α��� ó��
-- 7. ���̵� ã��
-- 8. ��й�ȣ ã��

--*** �����亯
-- 6. �亯�ϱ�

-- *** �޼���
-- 2. ���� -> ����ǥ��(update)