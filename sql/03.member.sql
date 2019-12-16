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

-- ������ Ȯ��
select * from member;

-- ������ �߰�
insert into member (id,pw,name,gender,birth,tel,email,grade) 
values('admin','1111','������','����','1995-12-18','010-2954-8296','012rlaehdgus@naver.com',9);
insert into member (id,pw,name,gender,birth,tel,email,grade) 
values('test','1111','ȫ�浿','����','1995-12-18','010-1111-1111','test@naver.com',1);
insert into member(id, pw, name, gender, birth, tel, email, grade)
values('angel', '1111' ,'������' ,'����', '1995-12-12', '010-1111-1111',
'test@webjjang.com', 1);

insert into member(id, pw, name, gender, birth, tel, email, grade)
values('flower', '1111' ,'����' ,'����', '1995-11-12', '010-1111-1111',
'test@webjjang.com', 1);

insert into member(id, pw, name, gender, birth, tel, email, grade)
values('red', '1111' ,'���̸�' ,'����', '1990-01-01', '010-1111-1111',
'test@webjjang.com', 1);

commit;