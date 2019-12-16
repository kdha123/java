select *
from(
    select rownum rnum, no, title, writer, writeDate, hit
    from(
        select no, title, writer, writeDate, hit from board order by no desc)
        )
where rnum between 11 and 20;

select count(*) cnt from board
where 1=2
or title like '%ÀÚ¹Ù%';