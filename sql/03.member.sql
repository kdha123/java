-- ȸ�� ���̺��� �����Ѵ�.(���࿡ ������ ������ ����.)
DROP TABLE MEMBER CASCADE CONSTRAINTS;

-- ȸ�� ���̺� ����
CREATE TABLE MEMBER(
  id varchar2(20) PRIMARY KEY,
  pw varchar2(20) NOT NULL ,
  name varchar2(30) NOT NULL,
  gender varchar2(6) NOT NULL CHECK(gender in('����','����')),
  birth date NOT NULL,
  tel varchar2(13),
  email varchar2(50) NOT NULL,
  regDate date DEFAULT sysdate,
  conDate date DEFAULT sysdate,
  status varchar2(6) DEFAULT '����' CHECK(status in('����','����','Ż��','�޸�')),
  -- 1:�Ϲ�ȸ��, 9: ������
  grade number(2) DEFAULT 1 
);