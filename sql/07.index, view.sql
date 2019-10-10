select * from member;

-- 이메일로 검색을 많이한다. -> 이메일로 인덱스를 만든다.
CREATE INDEX idx_member_email
on member(email);

-- 검색을 하는 예
SELECT id, name, tel, birth from member where email = '012rlaehdgus@naver.com';

-- 이름과 연락처로 검색을 많이 한다. -> 이름과 연락처(결합인덱스)로 인덱스를 만든다.
CREATE INDEX idx_member_delivery
on member(name, tel);

-- 검색을 하는 예
SELECT id, name, tel, birth from member where name = '김동현' and tel = '010-2954-8296';



select no, title, content, writer from board where no = 2;

-- 사용자 조회
select * from all_users;

-- 인덱스 조회
SELECT index_name,  table_name from user_indexes where table_owner = 'C##JAVA00';
select * from user_indexes;

select * from member;

-- 이름, 생년월일, 연락처만 가지고 볼 수 있는 테이블을 만들자.
-- CREATE VIEW 권한이 있어야한다. (grant create view to c##java00;)
CREATE OR REPLACE VIEW mem
as select name, birth, tel from member;

select * from mem;

select * from (
    select name, birth, tel from member
    );