select * from notice;

-- ���ڿ��� ����
select title, LENGTH(title) LENGTH, lengthb(title) lengthb
from notice;

-- ���� ��� : �տ� '����:'�̶�� ���
select concat('���� : ',title) from board;
-- ���� ��� : �տ� '[����:'+ ���� + ']'�̶�� ���
-- select concat('[���� : ',title,']') from board;  -- ����: concat()�� ���� ���� 2���� ���
select concat(concat('[����:', title), ']') from board;
-- concat() ����ϱ� ������� : '||' ���� ���� ���\
select '[���� : '||title||']' title from board;

-- ������ 4�ڸ��� ���
-- ������ ���̸� 0~4������ ǥ���Ѵ�. ,5) 5�� ���Ե��� �ʴ´�.
select SUBSTR(title,0,5) from board;
-- ����Ʈ ������ �ڸ��� : �ѱ��� 3����Ʈ
select SUBSTRB(title,0,5) from board;
-- SUBSTR(title,���۹�ȣ) : ���ۺ��� ���������� 
select SUBSTR(title,2) from board;
-- SUBSTR(title,������ġ, ������ ���ڼ�): ������ġ�� + ���� : �� ->����  / - ���� : ����->��
select SUBSTR(title,-3,2) from board;

-- INSTR(����, ã�� ����, ������ġ,�� ��°) 
-- ������ġ�� ���° ���������� �⺻���� 1�̴�.(��������)
select title, INSTR(title,'ra') from board;
select title, INSTR(title, 'ra',1,1) from board;

-- �ۼ��ڸ� 10�ڸ��� ���缭 ��� -> ������� '*'�� ä����.
select LPAD(writer,10,'*') from board;
select RPAD(writer,10,'*') from board;

-- ���鹮�ڸ� ����� trim()
select '['|| '    test    '||']' from dual;
select '['|| ltrim('    test    ')||']' from dual;
select '[' ||rtrim('       test       ') || ']' from dual;
select '[' || trim('       test       ') || ']' from dual;
-- ������ �߿��� ���ʿ� 't'�� �����ϴ� ó����
select '[' || ltrim('test','t') || ']' from dual;

--ROUND(����, ����� ���ϴ� �ڸ���)
select ROUND(987.654,2) from dual;
select ROUND(987.654,0) from dual;
select ROUND(987.654,-1) from dual;

--TRUNC(����, ���ϴ� �ڸ���)
select trunc(987.654,2), TRUNC(987.654,0),trunc(987.654,-2) from dual;

--MOD() : ���������� ���ϴ� �Լ�
--CEIL() : �־��� ���ڰ� ���� ����� ū ����
--FLOOR() : �־��� �Լ��� ���� ����� ���� ����
select MOD(121,10), CEIL(123.45), floor(123.45) from dual;

--power(����1,����2) : �¼��� �����ִ� �Լ�
select power(2,10) from dual;
