-- �����亯 ���̺� ���� , ������ ����
DROP TABLE qna CASCADE CONSTRAINTS;
DROP SEQUENCE qna_seq;

-- �����亯 ���̺� ����
CREATE TABLE qna(
  no NUMBER PRIMARY KEY,
  title VARCHAR2(300) NOT NULL,
  content VARCHAR2(2000) NOT NULL,
  id VARCHAR2(20) NOT NULL REFERENCES MEMBER(id),
  writeDate DATE DEFAULT sysdate,
  hit NUMBER DEFAULT 0,
  refNo NUMBER REFERENCES qna(no),
  ordNo NUMBER,
  levNo NUMBER,
  -- on delete : �����ϰ� �ִ� �����Ͱ� �������ٸ�
  ---# cascade : ���� ���� �ǰ� ����.(�ڵ����� ������ �ȴ�.)
  ---# set null : ����Ű�� �⺻������ null�� ����Ѵ�. �׷��� null�� ����� ����.
  ---# �⺻�� ���� �����ϰ� �����Ƿ� �����ϰ� �ִ� �����ʹ� ���� ���Ѵ�.
  parentNO NUMBER REFERENCES qna(no) ON DELETE CASCADE
);
CREATE SEQUENCE qna_seq;