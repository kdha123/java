-- 오라클의 모든 사용자를 확인하는 명령문
select * from ALL_USERS;

-- 사용자 생성 -관리자 권한(sys 접속) - 권한은 제외
-- create user 아이디 identified by 비밀번호;
-- drop user 아이디 : create <=> drop 
create user c##java04 identified by java04;
-- 사용자 권한 부여
-- grant 단위별 처리 권한, 롤(처리묶음) to 아이디;
-- grant<==> revoke(권한해지)
grant resource, connect, UNLIMITED TABLESPACE, create view to c##java04;
grant create view to c##java04;
