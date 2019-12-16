-- 회원 테이블을 제거한다.(만약에 없으면 오류가 난다.)
DROP TABLE MEMBER CASCADE CONSTRAINTS;

-- 회원 테이블 생성
CREATE TABLE MEMBER(
  id varchar2(20) PRIMARY KEY,
  pw varchar2(20) NOT NULL ,
  name varchar2(30) NOT NULL,
  gender varchar2(6) NOT NULL CHECK(gender in('남자','여자')),
  birth date NOT NULL,
  tel varchar2(13),
  email varchar2(50) NOT NULL,
  regDate date DEFAULT sysdate,
  conDate date DEFAULT sysdate,
  status varchar2(6) DEFAULT '정상' CHECK(status in('정상','강퇴','탈퇴','휴면')),
  -- 1:일반회원, 9: 관리자
  grade number(2) DEFAULT 1 
);

-- 데이터 확인
select * from member;

-- 데이터 추가
insert into member (id,pw,name,gender,birth,tel,email,grade) 
values('admin','1111','관리자','남자','1995-12-18','010-2954-8296','012rlaehdgus@naver.com',9);
insert into member (id,pw,name,gender,birth,tel,email,grade) 
values('test','1111','홍길동','남자','1995-12-18','010-1111-1111','test@naver.com',1);
insert into member(id, pw, name, gender, birth, tel, email, grade)
values('angel', '1111' ,'김혜수' ,'여자', '1995-12-12', '010-1111-1111',
'test@webjjang.com', 1);

insert into member(id, pw, name, gender, birth, tel, email, grade)
values('flower', '1111' ,'설현' ,'여자', '1995-11-12', '010-1111-1111',
'test@webjjang.com', 1);

insert into member(id, pw, name, gender, birth, tel, email, grade)
values('red', '1111' ,'아이린' ,'여자', '1990-01-01', '010-1111-1111',
'test@webjjang.com', 1);

commit;