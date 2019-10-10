-- 질문답변 테이블 제거 , 시퀸스 제거
DROP TABLE qna CASCADE CONSTRAINTS;
DROP SEQUENCE qna_seq;

-- 질문답변 테이블 생성
CREATE TABLE qna(
  no NUMBER PRIMARY KEY,
  title VARCHAR2(300) NOT NULL,
  content VARCHAR2(2000) NOT NULL,
  id VARCHAR2(20) NOT NULL REFERENCES MEMBER(id),
  writeDate DATE DEFAULT sysdate,
  hit NUMBER DEFAULT 0,
  refNo NUMBER REFERENCES qna(no),
  ordNo NUMBER,
  levNo NUMBER,
  -- on delete : 참조하고 있는 데이터가 지워진다면
  ---# cascade : 같이 삭제 되게 하자.(자동으로 삭제가 된다.)
  ---# set null : 참조키는 기본적으로 null을 허용한다. 그래서 null로 만들어 놓자.
  ---# 기본은 내가 참조하고 있으므로 참조하고 있는 데이터는 삭제 못한다.
  parentNO NUMBER REFERENCES qna(no) ON DELETE CASCADE
);
CREATE SEQUENCE qna_seq;