-- PL/SQL 활용하여 다음 기능을 구현하시오.
--1. 공지사항 리스트 출력
--2. 공지사항 보기 출력(리스트 출력된 내용 중 하나)
--3. 공지사항 등록
--4. 공지사항 삭제(리스트 출력된 내용 중 하나)
-- DECLARE, BEGIN, END;/ 형식으로 처리
-- 트리거, 저장프로시저, 스케쥴러 개념

-- 리스트출력
DECLARE
 vno notice.no%TYPE;
 vtitle notice.title%TYPE;
 vcontent notice.content%TYPE;
    cursor c1 is 
        select no, title, content from notice order by no desc;
BEGIN
 open c1;
    LOOP
    FETCH c1 INTO vno, vtitle, vcontent;
    EXIT WHEN c1%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
    END LOOP;
close c1;
END;
/

-- 보기출력
DECLARE
 vno notice.no%TYPE;
 vtitle notice.title%TYPE;
 vcontent notice.content%TYPE;
 BEGIN
 select no,title, content into vno, vtitle, vcontent from notice
 where no = 22;
 DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
 END;
 /

--등록 출력
DECLARE
vno notice.no%TYPE;
vtitle notice.title%TYPE := '&title';
vcontent notice.content%TYPE := '&content';
BEGIN
insert into notice(no,title,content) values(notice_seq.nextval,vtitle,vcontent);
DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
commit;
END;
/

--4. 공지사항 삭제(리스트 출력된 내용 중 하나)
DECLARE
vno notice.no%TYPE;
vtitle notice.title%TYPE;
vcontent notice.content%TYPE;
BEGIN
delete from notice where no = 61;
DBMS_OUTPUT.PUT_LINE(vno||'-'||vtitle||'-'||vcontent);
END;
/
 