-- 공지사항에 필요한 쿼리 작성
-- 1. 공지 리스트 : select 번호 역순으로 : 번호, 제목(일반 사용자)
select no, title from notice order by no desc;

-- 2. 공지 등록 : 제목, 내용 -pk 번호는 반드시 입력을 해야한다. notice_seq.nextval사용 -> 3개 이상의 글
insert into notice(no,title,content) values(notice_seq.nextval, '공지하나','한개완료');
insert into notice(no,title,content) values(notice_seq.nextval, '공지둘','두개완료');
insert into notice(no,title,content) values(notice_seq.nextval, '공지셋','세개완료');

-- 3. 공지 보기 : 번호, 제목, 내용, 등록일 : 등록되어진 공지 중에서 하나를 선택
select no, title, content, startDate from notice where no = 5;

-- 4. 공지 수정 : 제목, 내용->등록되어진 공지 중에서 하나를 선택
update notice set title = '공지수정', content ='공지수정' where no = 5;

-- 5. 공지 삭제 : 등록되어진 공지 중에서 하나를 삭제
delete from notice where no = 4;

-- select * from notice;
commit;
