delete from qna;
commit;

--- 1. qna list
select q.no,q.title, q.id, m.name, q.writeDate, q.hit, q.levNo from qna q, member m
where q.id = m.id order by q.refNo desc, q.ordNo asc ;

--- 2. �����ϱ� write
insert into qna(no,title, content,id,refNo, ordNo, levNo) 
values(qna_seq.nextval,'�ڹٶ�?','�ñ��մϴ�.','test',qna_seq.nextval,1,0);
commit;

select * from qna order by refNo desc,ordNo asc;

--- 2-1 �亯�ϱ� answer
-- 1�� �ۿ� ���� �亯
insert into qna(no,title, content,id,refNo, ordNo, levNo, parentNO)
values(qna_seq.nextval,'[�亯]�ڹٶ�?','����̴�.','admin',1,2,1,1);
commit;

---2-2 �۹�ȣ 2���� ���� ���鼭 �亯�� �亯�ϱ� answer
-- �۹�ȣ 2���� �����ִ�.(�ڹٿ��� ó���ؼ� �����ִ�.)
select * from qna where no = 2;
-- �亯�� �亯�� �ش�Ǵ� �����͸� �ڹٿ��� �����Ѵ�.
-- ���ñ�(���θ���) = ���ñ�(���°�),
-- ������ȣ(��) = ������ȣ(��)+1 -> DBó���� �� ������ȣ�� ���ų� ū �������� ��� +1�Ѵ�.
update qna set ordNo = ordNo + 1 where refNo = 1 and ordNo >= 3;
commit;
-- �鿩����(���ο�) : �鿩����(��)+1
-- �θ�� ���(���ο�) = �۹�ȣ(��)
-- ����, ������ ����� �Է�, ���̵�(�α���)
insert into qna(no,title, content,id,refNo, ordNo, levNo, parentNO)
values(qna_seq.nextval,'[�亯][�亯]�ڹٶ�?','����?','test',
1,3,2,2);
commit;

---2-3 �۹�ȣ 2���� ���� ���鼭 �亯�� �亯�ϱ� answer
-- �۹�ȣ 2���� �����ִ�.(�ڹٿ��� ó���ؼ� �����ִ�.)
select * from qna where no = 2;
-- �亯�� �亯�� �ش�Ǵ� �����͸� �ڹٿ��� �����Ѵ�.
-- ���ñ�(���θ���) = ���ñ�(���°�),1
-- ������ȣ(��) = ������ȣ(��)+1 -> DBó���� �� ������ȣ�� ���ų� ū �������� ��� +1�Ѵ�.
update qna set ordNo = ordNo + 1 where refNo = 1 and ordNo >= 3;
commit;
-- �鿩����(���ο�) : �鿩����(��)+1, 1>2
-- �θ�� ���(���ο�) = �۹�ȣ(��)
-- ����, ������ ����� �Է�, ���̵�(�α���)
insert into qna(no,title, content,id,refNo, ordNo, levNo, parentNO)
values(qna_seq.nextval,'[�亯][�亯]�ڹٶ�2?','�� �ڹ�?','test',
1,3,2,2);
commit;