-- ����Ŭ�� ��� ����ڸ� Ȯ���ϴ� ��ɹ�
select * from ALL_USERS;

-- ����� ���� -������ ����(sys ����) - ������ ����
-- create user ���̵� identified by ��й�ȣ;
-- drop user ���̵� : create <=> drop 
create user c##java00 identified by java00;
-- ����� ���� �ο�
-- grant ������ ó�� ����, ��(ó������) to ���̵�;
-- grant<==> revore(��������)
grant resource, connect, UNLIMITED TABLESPACE, create view to c##java00;
grant create view to c##java00;
