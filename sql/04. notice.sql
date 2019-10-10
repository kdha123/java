-- �������� ���̺� ����
DROP TABLE notice CASCADE CONSTRAINTS;
-- �������� ������ ����
DROP SEQUENCE notice_seq;
-- �������� ���̺� ����
-- ���� ������ �̸��� �̿��ؼ� �������� �����ϱ� : CONSTRAINT Ű���尡 �ݵ�� �ʿ�
CREATE TABLE notice(
  no NUMBER CONSTRAINT notice_no_pk PRIMARY KEY,
  title VARCHAR2(300) CONSTRAINT notice_title_nn NOT NULL,
  content VARCHAR2(2000) CONSTRAINT notice_content_nn NOT NULL,
  startDate DATE DEFAULT SYSDATE,
  endDate DATE DEFAULT '9999-12-30',
  writeDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
  );
  -- �������׿� no���� ����� ������ ����
CREATE SEQUENCE notice_seq;

-- �������� ������ �Է�
INSERT INTO notice(no, title, content)
VALUES(NOTICE_SEQ.nextval, 'oracle data', 'data');

-- ������ Ȯ��
--  * : ��� �÷�
SELECT * from notice;

-- Ʈ������
-- ���� ����
COMMIT;
-- ���
-- ROLLBACK;