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
  parentNO NUMBER REFERENCES qna(no) ON DELETE CASCADE
);
CREATE SEQUENCE qna_seq;

insert into qna(no,title,content,id) values(qna_seq.nextval, '�ñ��ؿ�~','�̰��� �ñ��մϴ�.','kims');
insert into qna(no,title,content,id) values(qna_seq.nextval, '�̰͵� �ñ��ؿ�~','�̰͵� �ñ��մϴ�.','sons');
insert into qna(no,title,content,id) values(qna_seq.nextval, '�̰͵� �ñ���~','�̰͵� �ñ��ؿ�.','lees');

commit;