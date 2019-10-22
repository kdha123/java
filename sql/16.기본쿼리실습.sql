--- 게시판 기본 쿼리
-- 1. list -> 대상데이터 -> rownum추가 -> 페이지 데이터(1~10페이지)
select *
from(
    select rownum rnum, no, title, writer, writeDate,hit
    from (
        select no, title, writer, writeDate, hit
        from board
        order by no desc
))where rnum between 1 and 10;

--2. write
insert into board(no,title, content, writer) values(board_seq.nextval,'title','content','kim');
commit;

--3. view
update board set hit = hit + 1
where no = 2;
commit;
select no,title, content, writer, writeDate, hit from board where no = 2;

--4. update
update board set title = 'big', content = 'bigdata', writer = 'kim'
where no = 2;
commit;

--5. delete
delete from board where no = 21;
commit;

-- message 기본쿼리
-- 1.list
select ms.no, ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, ms.acceptDate
from message ms, member sm, member am
where ms.sender = sm.id and ms.accepter = am.id;

-- 2. view 
-- 2-1. 보낸 사람이 메세지를 확인할 때 1번메세지 보기(admin이 보냈다.)
select no ,ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, ms.acceptDate
from message ms, member sm, member am
where ms.no = 1 and ms.sender = sm.id and ms.accepter = am.id;

-- 2-2. 받는 사람이 메세지를 확인할 때(accepter가 test인 경우)
update message set acceptDate = sysdate
where no = 1 and acceptDate is null;
commit;
select no ,ms.content, ms.sender, sm.name, ms.sendDate, ms.accepter, am.name, ms.acceptDate
from message ms, member sm, member am
where ms.no = 1 and ms.sender = sm.id and ms.accepter = am.id;

-- 3. write
insert into message(no, content, sender,accepter) values(message_seq.nextval, '잘지냅니다.','test','admin');
commit;

-- 4. update - 보낸사람이 받는사람이 확인을 하지 않은 경우만 수정이 가능하다.
update message set content = '매우 잘지냅니다.' where no = 21 and acceptDate is null;
commit;

-- 5. delete - 보낸사람 : 받은사람이 읽지 않는 경우만 삭제 가능(선택)
-- 받은 사람은 받은 메시지를 삭제할 수 있다.
delete from message where no = 3 and acceptDate is null;
commit;

-- 이미지 게시판 기본쿼리
-- 1. list
select i.no, i.title, i.content, m.name,i .id, i.writeDate, i.fileName 
from member m, image i
where m.id = i.id;

-- 2. view
select i.no, i.title, i.content, m.name,i.id, i.writeDate, i.fileName 
from member m, image i
where m.id = i.id and i.no = 1;

-- 3. write
insert into image(no,title, content,id,fileName) 
values(image_seq.nextval,'정말 좋은 사진','정말정말 좋은 사진','test','very good photo.jpg');
commit;

-- 4. update
update image set title = '정말 좋은 사진', content = '진짜 좋은 사진', writeDate = sysdate, fileName = 'goodphoto.jpg' where no = 1;
commit;

-- 5. delete
delete from image where no = 21;
commit;