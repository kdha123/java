-- 이미지 테이블 제거 
DROP TABLE image CASCADE CONSTRAINTS;
DROP SEQUENCE image_seq;
-- 이미지 테이블 생성
CREATE TABLE image(
  no NUMBER CONSTRAINT image_no_pk PRIMARY KEY,
  title VARCHAR2(300) CONSTRAINT image_title_nn NOT NULL,
  content VARCHAR2(2000) CONSTRAINT image_content_nn NOT NULL,
  id VARCHAR2(20) CONSTRAINT image_id_nn NOT NULL
                  CONSTRAINT image_id_fk REFERENCES member(id),
  writeDate DATE DEFAULT sysdate,
  fileName VARCHAR2(50) CONSTRAINT image_fileName_nn NOT NULL 
  );
  CREATE SEQUENCE image_seq;