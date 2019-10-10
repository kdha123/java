-- 공지사항 테이블 제거
DROP TABLE notice CASCADE CONSTRAINTS;
-- 공지사항 시퀸스 제거
DROP SEQUENCE notice_seq;
-- 공지사항 테이블 생성
-- 제약 조건의 이름을 이용해서 제약조건 설정하기 : CONSTRAINT 키워드가 반드시 필요
CREATE TABLE notice(
  no NUMBER CONSTRAINT notice_no_pk PRIMARY KEY,
  title VARCHAR2(300) CONSTRAINT notice_title_nn NOT NULL,
  content VARCHAR2(2000) CONSTRAINT notice_content_nn NOT NULL,
  startDate DATE DEFAULT SYSDATE,
  endDate DATE DEFAULT '9999-12-30',
  writeDate DATE DEFAULT SYSDATE,
  updateDate DATE DEFAULT SYSDATE
  );
  -- 공지사항에 no에서 사용할 시퀸스 생성
CREATE SEQUENCE notice_seq;

-- 공지사항 데이터 입력
INSERT INTO notice(no, title, content)
VALUES(NOTICE_SEQ.nextval, 'oracle data', 'data');

-- 데이터 확인
--  * : 모든 컬럼
SELECT * from notice;

-- 트랜젝션
-- 완전 적용
COMMIT;
-- 취소
-- ROLLBACK;