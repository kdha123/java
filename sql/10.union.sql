-- �Խ���
select *from board order by writeDate desc; 

-- ��������
select * from notice order by writeDate desc;

--- �̹���
select * from image order by writeDate desc;

insert into image VALUES(image_seq.nextval,'������', '���ִ�.','test', sysdate,'my.jpg');
commit;

-- �������׿��� �ҷ�����
select 'notice' table_name, no,title, writeDate from notice;
-- �̹������� �ҷ�����
select 'image' table_name, no, title, writeDate from image;

-- ��������, �̹������� �ҷ�����
select 'notice' table_name, no,title, writeDate from notice 
union
select 'image' table_name, no, title, writeDate from image;

select table_name, no, title, writeDate
from(
-- �������׿��� �ҷ�����
select 'notice' table_name, no, title, writeDate from notice
union
select 'image' table_name, no, title, writeDate from image)
order by writeDate desc;

