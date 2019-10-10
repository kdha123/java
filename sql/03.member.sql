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