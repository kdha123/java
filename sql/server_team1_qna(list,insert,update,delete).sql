-- 질문답변 운영에 필요한 쿼리 작성
-- 1. 리스트
select no,title,content,id,writeDate,hit from qna;
-- 2. 보기 - 조회수 : 1증가 먼저 시킨다(update)
update qna set hit = hit + 1 where no = 2;
select no, title, content,id, writeDate,hit from qna where no = 2;
commit;
-- 3. 등록
insert into qna(no,id,title,content) values(notice_seq.nextval,'sons','질문','질문답변');
commit;
-- 4. 수정
update  qna set title = '질문이요', content ='이게뭐야' where no = 1;
commit;
-- 5. 삭제
delete from qna where no = 3;
commit;

-- **참조 키로 등록되어 있는 경우 부모키가 삭제되면 자식키의 데이터를
--   어떻게 할 것인지 제약 조건으로 사용해서 설정 -> 없으면 부모키의 데이터삭제불가
-- *** 회원관리 - 위에 것 외 추가
-- 6. 로그인 처리
-- 7. 아이디 찾기
-- 8. 비밀번호 찾기

--*** 질문답변
-- 6. 답변하기

-- *** 메세지
-- 2. 보기 -> 읽음표시(update)