select * from member;

-- �̸��Ϸ� �˻��� �����Ѵ�. -> �̸��Ϸ� �ε����� �����.
CREATE INDEX idx_member_email
on member(email);

-- �˻��� �ϴ� ��
SELECT id, name, tel, birth from member where email = '012rlaehdgus@naver.com';

-- �̸��� ����ó�� �˻��� ���� �Ѵ�. -> �̸��� ����ó(�����ε���)�� �ε����� �����.
CREATE INDEX idx_member_delivery
on member(name, tel);

-- �˻��� �ϴ� ��
SELECT id, name, tel, birth from member where name = '�赿��' and tel = '010-2954-8296';



select no, title, content, writer from board where no = 2;

-- ����� ��ȸ
select * from all_users;

-- �ε��� ��ȸ
SELECT index_name,  table_name from user_indexes where table_owner = 'C##JAVA00';
select * from user_indexes;

select * from member;

-- �̸�, �������, ����ó�� ������ �� �� �ִ� ���̺��� ������.
-- CREATE VIEW ������ �־���Ѵ�. (grant create view to c##java00;)
CREATE OR REPLACE VIEW mem
as select name, birth, tel from member;

select * from mem;

select * from (
    select name, birth, tel from member
    );