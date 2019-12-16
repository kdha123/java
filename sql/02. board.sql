-- BOARD ���̺��� �����Ѵ�.(���࿡ ������ ������ ����.)
DROP TABLE board CASCADE CONSTRAINTS;
drop sequence board_seq;
-- �Խ��� ���̺� �ۼ�
-- �Խ��� ���̺� ����
-- 1. �Խ��� ���� ���� �ۼ�
-- 2. ()���̿� �÷� �̸��� ","�� �̿��ؼ� �����Ѵ�.
-- 3. �÷��� ���� ������ Ÿ���� �����Ѵ�.
-- 4. ���̸� ���Ѵ�. �ѱ��� 3����Ʈ�� �����Ѵ�.
-- 5. ���������� ����
--     NN : NOT NULL, PK:PRIMARY KEY, FK:REFERENCES ���̺�(�÷�)
CREATE TABLE board(
  no NUMBER PRIMARY KEY,
  title VARCHAR2(300) NOT NULL,
  content VARCHAR2(2000) NOT NULL,
  writer VARCHAR2(30) NOT NULL,
  writeDate DATE DEFAULT SYSDATE,
  hit NUMBER DEFAULT 0
);
CREATE SEQUENCE board_seq;
