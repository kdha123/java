-- å�� �뿩�Ϸ����Ѵ�. �׷��� ���÷κ��� 7�� ���� ��¥(+7)�� ���.
select sysdate + 7 from dual;

-- ��ź������ ���� ��¥�� ������.
-- to_date(����Ʈ ���Ŀ� �´� ���ڿ�)-> ��¥������ ��ȯ
-- �� ���� ��¥�� ���� ��¥ ������ �ϼ��� ���´�. -> �Ҽ������ϴ� �ð��� �ǹ��Ѵ�.
select to_date('2019-12-25') - sysdate from dual;

-- �����͸� ���� ��¥���� ǥ���ؾ߸��Ѵ�.
select 'data' from dual
where to_date('2019-10-15') >= sysdate;
-- sysdate�� ��¥�� �ð��� ������ �ִ�. �׷��� ���� '2019-10-15 00:00:00'
-- ����� ó���� �Ϸ��� ���� ��¥�� �ð��� �������Ѵ�.
-- trunc���� �ذ�
select 'data' from dual
where to_date('2019-10-15') >= trunc(sysdate);
-- where to_date('2019-10-15') + 1 >= sysdate;

-- �̴��� �������� ���
select last_day(sysdate) from dual;
select to_date('2019-11-1')-1 from dual;

-- ��¥������ ���ϴ� ���Ŀ� �°� ���ڿ��� �����
select to_char(sysdate,'yyyy-mm-dd  hh24:mi:ss') today from dual;