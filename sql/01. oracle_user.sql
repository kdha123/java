-- ����Ŭ�� ��� ����ڸ� Ȯ���ϴ� ��ɹ�
select * from ALL_USERS;

-- ����� ���� -������ ����(sys ����) - ������ ����
-- create user ���̵� identified by ��й�ȣ;
-- drop user ���̵� : create <=> drop 
create user c##java04 identified by java04;
-- ����� ���� �ο�
-- grant ������ ó�� ����, ��(ó������) to ���̵�;
-- grant<==> revoke(��������)
grant resource, connect, UNLIMITED TABLESPACE, create view to c##java04;
grant create view to c##java04;
