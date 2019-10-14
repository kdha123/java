--- -> 생성되어진 계정으로 접속해서 처리한다.
-- 테이블 제거와 생성
 drop table  message cascade constraints;
 
create table message(
 no number primary key,
 content varchar2(2000) not null,
 sender varchar2(20) not null references member(id),
 sendDate date default sysdate,
 accepter varchar2(20) not null references member(id),
 acceptDate date default null
 );
 -- 시퀸스 제거와 생성
 drop sequence message_seq;
 create sequence message_seq;
 
 -- index, view
 
-- 샘플데이터 : member table의 데이터를 확인해서 있는 id 사용
-- 메시지 보내기 : 데이터 넣기 - 보내는 사람, 받는 사람, 메세지 내용  
insert into message(no,content,sender,accepter)
values (message_seq.nextval,'잘 지내지?','admin','test');
insert into message(no,content,sender,accepter)
values (message_seq.nextval,'답 부탁','admin','test');
insert into message(no,content,sender,accepter)
values (message_seq.nextval,'잘 지내고 있지!','test','admin');
commit;

select *from message;
-- 보낸 메시지 리스트(test)
select no,sender, sendDate, accepter, acceptDate from message where sender = 'test';

-- 받은 메시지 리스트(admin)
select no,sender, sendDate, accepter, acceptDate from message where accepter = 'test';
select no,sender, sendDate, accepter, acceptDate from message where sender = 'test';

-- 받은 메시지 리스트(test:읽지 않은 메시지)
select no, sender, sendDate, accepter, acceptDate from message
where accepter = 'test' and acceptDate is null;

-- 받은 메시지 리스트(test:읽은 메시지)
select no,sender, sendDate, accepter, acceptDate from message
where accepter = 'test' and acceptDate is not null;

-- 메시지 읽기
-- 읽은 데이터로 처리 -> 받은 날짜를 오늘 날짜로 바꾸기
update message set acceptDate = sysdate
where no = 2 and acceptDate is null;
commit;
-- 읽은 데이터 불러오기
 select no, sender, sendDate, accepter, acceptDate from message
where no = 2;

