-- 회원
-- 등급
select * from grade;

select* from member;

-- 로그인 처리 : 아이디, 이름, 등급, 등급명 -> member,grade 2개의 테이블에서 가져온다 >>join
-- from t,t where() and (조인 조건) -> Oracle join
select m.id, m.name, m.grade, g.gradeName from member m, grade g
where m.grade = g.grade;

-- 이미지 정보 표시 - 번호, 제목, 내용, 작성자아이디, 작성자이름, 작성일, 파일명
select i.no, i.title, i.content, m.name,i .id, i.writeDate, i.fileName from member m, image i
where m.id = i.id;

-- 질문답변 - 번호, 제목, 작성자 아이디, 작성자 이름, 관련글번호, 순서번호, 들여쓰기번호
select q.no, q.title, q.id, m.name, q.refNo, q.ordNo, q.levNo
from qna q, member m
where q.id = m.id
order by refNo desc, ordNo asc;

-- 메시지 - 번호, 내용, 보낸사람아이디, 보낸사람이름, 보낸날짜, 받는사람 아이디, 받는사람이름
--- 받은날짜
select * from message;
select ms.no, ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, acceptDate
from message ms, member sm, member am 
where ms.accepter = am.id and ms.sender = sm.id;

