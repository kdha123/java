-- 게시판
select *from board order by writeDate desc; 

-- 공지사항
select * from notice order by writeDate desc;

--- 이미지
select * from image order by writeDate desc;

insert into image VALUES(image_seq.nextval,'내사진', '멋있다.','test', sysdate,'my.jpg');
commit;

-- 공지사항에서 불러오기
select 'notice' table_name, no,title, writeDate from notice;
-- 이미지에서 불러오기
select 'image' table_name, no, title, writeDate from image;

-- 공지사항, 이미지에서 불러오기
select 'notice' table_name, no,title, writeDate from notice 
union
select 'image' table_name, no, title, writeDate from image;

select table_name, no, title, writeDate
from(
-- 공지사항에서 불러오기
select 'notice' table_name, no, title, writeDate from notice
union
select 'image' table_name, no, title, writeDate from image)
order by writeDate desc;

