-- 로그인 처리를 위한 쿼리
select m.id, m.name, g.gradeName, m.grade from member m, grade g
-- 사용자에게 받은 아이디와 비밀번호 데이터를 바꾸기 위해 'test'-->?, '1111'-->?
where (id = 'test' and pw = '1111')and(m.grade = g.grade);