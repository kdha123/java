delete from qna;
commit;

--- 1. qna list
select q.no,q.title, q.id, m.name, q.writeDate, q.hit, q.levNo from qna q, member m
where q.id = m.id order by q.refNo desc, q.ordNo asc ;

--- 2. 질문하기 write
insert into qna(no,title, content,id,refNo, ordNo, levNo) 
values(qna_seq.nextval,'자바란?','궁금합니다.','test',qna_seq.nextval,1,0);
commit;

select * from qna order by refNo desc,ordNo asc;

--- 2-1 답변하기 answer
-- 1번 글에 대한 답변
insert into qna(no,title, content,id,refNo, ordNo, levNo, parentNO)
values(qna_seq.nextval,'[답변]자바란?','언어이다.','admin',1,2,1,1);
commit;

---2-2 글번호 2번인 글을 보면서 답변에 답변하기 answer
-- 글번호 2번을 보고있다.(자바에서 처리해서 보고있다.)
select * from qna where no = 2;
-- 답변의 답변에 해당되는 데이터를 자바에서 셋팅한다.
-- 관련글(새로만든) = 관련글(보는것),
-- 순서번호(새) = 순서번호(보)+1 -> DB처리할 떄 순서번호와 같거나 큰 데이터인 경우 +1한다.
update qna set ordNo = ordNo + 1 where refNo = 1 and ordNo >= 3;
commit;
-- 들여쓰기(새로운) : 들여쓰기(보)+1
-- 부모글 계산(새로운) = 글번호(보)
-- 제목, 내용은 사용자 입력, 아이디(로그인)
insert into qna(no,title, content,id,refNo, ordNo, levNo, parentNO)
values(qna_seq.nextval,'[답변][답변]자바란?','언어란?','test',
1,3,2,2);
commit;

---2-3 글번호 2번인 글을 보면서 답변에 답변하기 answer
-- 글번호 2번을 보고있다.(자바에서 처리해서 보고있다.)
select * from qna where no = 2;
-- 답변의 답변에 해당되는 데이터를 자바에서 셋팅한다.
-- 관련글(새로만든) = 관련글(보는것),1
-- 순서번호(새) = 순서번호(보)+1 -> DB처리할 떄 순서번호와 같거나 큰 데이터인 경우 +1한다.
update qna set ordNo = ordNo + 1 where refNo = 1 and ordNo >= 3;
commit;
-- 들여쓰기(새로운) : 들여쓰기(보)+1, 1>2
-- 부모글 계산(새로운) = 글번호(보)
-- 제목, 내용은 사용자 입력, 아이디(로그인)
insert into qna(no,title, content,id,refNo, ordNo, levNo, parentNO)
values(qna_seq.nextval,'[답변][답변]자바란2?','꼭 자바?','test',
1,3,2,2);
commit;