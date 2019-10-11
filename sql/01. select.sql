-- select 정리

--- * : 모든 데이터를 가져오기 - 현업에서 잘 사용하지 않는다.
select * from board;

--- 컬럼, ... : 원하는 컬럼의 데이터 가져오기
select no, title from board;

--- 컬럼, 표현식(연산, 값)...
select 'board', sysdate, title from board;
-- [1] 제목 -> 문자열 이어붙이기 연산자(||)를 이용해서 작성 -> 불러다가 사용할 때를 위해서
-- 이름을 붙인다. 이때 붙여진 이름을 별칭(Alias)이라고 하고 별칭을 통해서 데이터를 가져간다.
select '['||no||']' || title  title from board; 

-- 작성자가 몇사람 안될때 어떤 사람이 글을 썼는지 알아보고 싶다. -> 같은 사람의 이름은 한번만 출력
select writer from board order by writer;
select DISTINCT writer from board order by writer;

-- 게시판 리스트 최근 작성된 글을 위에 올리자. : no desc 정렬
select no, title from board order by no desc;

-- 맨 위에서 10개의 데이터를 가져오자(513~504)
select no, title from board where no <=513 and no >= 504 order by no desc;

select no, title from board where no between 504 and 513 order by no desc;

-- 513, 510, 508, 505번 글의 데이터 가져오기
select no, title from board where no = 513 or no = 510 or no = 508 or no = 505
order by no desc;

-- 위와 같이 떨어져 있는 여러개의 데이터를 가져올때 사용하는 or 대신에 in
select no, title from board where no in (513, 510, 508, 505)
order by no desc;

-- 검색어 '자바'가 제목이나 내용에 포함되어 있는 데이터 가져오기
select no, title, content from board 
where title like '%자바%' or content like '%자바%' order by no desc;

-- where name = null (X) / where name is null <-> where name is not null (O)

--- 페이지 처리를 위한 select 작성
-- 1. 대상이 되는 모든 데이터를 정렬해서 불러오기
select no, title, writer, writeDate, hit from board order by no desc;
-- 2. 정렬된 대상 데이터에 번호를 붙인다. (rownum)
select rownum rnum, no, title, writer, writeDate, hit
from(select no, title, writer, writeDate, hit from board order by no desc);

-- 3. 순서번호가 1~10(한 페이지에 10개의 데이터를 표시한다고 하면)
select rnum, no, title, writer, writeDate, hit
from(
    select rownum rnum, no, title, writer, writeDate, hit
    from(
        select no, title, writer, writeDate, hit from board order by no desc)
        )
where rnum between 1 and 10;

-- 전체 데이터의 갯수 -> 페이지 클릭을 위해서 전체 페이지 구해야만한다.
select COUNT(*) from board;
