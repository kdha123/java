select * from member;

-- 회원의 남자와 여자의 비율  - count
select count(*) from member
where gender = '남자';
select count(*) from member
where gender = '여자';
SELECT COUNT(*) FROM member;

select gender, count(*) 인원, count(*)/(select count(*)from member)* 100 퍼센트 from member group by gender;

-- join - 데이터가 여러 테이블에 (중복 배제)분산되어 있다. ->합치자.
-- 곱 - 1 * 5 -> 5개 : 출석부 - 학생 * 날짜 * 시간
SELECT no, title, content, image.id,writeDate,fileName, name, gender, birth, email
from image, member;

select * from image;
insert into image values(image_seq.nextval,'좋은사진','참좋은사진','admin',sysdate,'photo.jpg');
commit;

-- member의 id와 image id가 같은 데이터를 조인
-- inner join>> equals join
SELECT no, title, content, image.id,writeDate,fileName, name, gender, birth, email
from image, member
where image.id = member.id;

-- join 표준화(오라클 조인)
select i.no, i.title, i.content, i.id, i.writeDate, i.fileName,
m.name, m.gender, m.birth, m.email
from image i, member m
where i.id = m.id;

-- join 표준화(ANSI 조인)
select i.no, i.title, i.content, i.id, i.writeDate, i.fileName,
m.name, m.gender, m.birth, m.email
from image i join member m
on i.id = m.id;

-- outter join을 위한 데이터 : 회원스케쥴 시스템
-- no, id, date, content, image
create table schedule(
    no number primary key,
    id varchar2(20) references member(id),
    schDate date default sysdate ,
    content varchar2(1000) not null
    );
create sequence schedule_seq;

drop table schedule;
drop sequence schedule_seq;

create table schedule_img(
    sno number primary key,
    no number references schedule(no),
    fileName varchar2(50)
);
create sequence schedule_img_seq;

-- 스케쥴
insert into schedule
values(schedule_seq.nextval,'admin',sysdate,'일정입니다.');
insert into schedule
values(schedule_seq.nextval, 'admin', sysdate, '추가일정입니다.');
commit;

select*from schedule;

-- 2번 추가일정에 이미지 추가하기
insert into schedule_img values(schedule_img_seq.nextval, 2, 's1.jpg');

-- 이미지가 있는(schedule_img 테이블에) 데이터는 나온다.
-- schedule_img에 데이터가 없는 경우 equals 조인이 불가하다.(데이터 못 가져옴)
select s.no,s.schDate,s.content,i.fileName from schedule s, schedule_img i
where s.no = i.no;
-- 스케쥴 3개가 다 나와야한다. 한쪽의 데이터가 없더라도 데이터는 출력이 되어야한다.
select s.no,s.schDate,s.content,i.fileName from schedule s, schedule_img i
where s.no = i.no(+);
