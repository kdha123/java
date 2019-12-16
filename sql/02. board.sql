-- BOARD 테이블을 제거한다.(만약에 없으면 오류가 난다.)
DROP TABLE board CASCADE CONSTRAINTS;
drop sequence board_seq;
-- 게시판 테이블 작성
-- 게시판 테이블 생성
-- 1. 게시판 생성 형식 작성
-- 2. ()사이에 컬럼 이름을 ","를 이용해서 나열한다.
-- 3. 컬럼에 따른 데이터 타입을 정의한다.
-- 4. 길이를 정한다. 한글은 3바이트를 차지한다.
-- 5. 제약조건을 지정
--     NN : NOT NULL, PK:PRIMARY KEY, FK:REFERENCES 테이블(컬럼)
CREATE TABLE board(
  no NUMBER PRIMARY KEY,
  title VARCHAR2(300) NOT NULL,
  content VARCHAR2(2000) NOT NULL,
  writer VARCHAR2(30) NOT NULL,
  writeDate DATE DEFAULT SYSDATE,
  hit NUMBER DEFAULT 0
);
CREATE SEQUENCE board_seq;
