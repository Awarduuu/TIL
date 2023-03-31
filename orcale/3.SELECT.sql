/*
   SELECT���� - DQL����
    : ����
    select distinct | * | �÷��� as ��Ī, �÷��� ��Ī,....   : ���� ���� :PROJECTION
    from ���̺��̸�     
    [where ���ǽ� ]  : ���ڵ�(Ʃ��)����  - SELECTION
    [order by �÷��� desc | asc , .. ] -����
    
    
    * distinct �� �ߺ����ڵ带 ����
    * AS �� �÷��� ��Ī ����� 
    * �������
      SELECT   3) 
      FROM     1)
      WHERE    2) 
      ORDER BY 4) 
    
*/

--EX) SCOTT���� ���� 

SELECT * FROM EMP; --������̺�
SELECT * FROM DEPT;--�μ��������̺�

--1) EMP���̺��� ���ϴ� �÷�(��Ī)
select empno as �����ȣ, ename as �̸�, hiredate as ��볯¥, job as ����, sal as �޿�
from emp;

--2) �ߺ��� �����ϱ� - DISTINCT
 --EX) �츮ȸ�翡 � JOB�ִ��� JOB�� ������ �˰�ʹ�!!!
select distinct job as ����
from emp;
 
--3) ���� ����� 
 -- �޿��� 3000�̻��� ��� �˻�
select *
from emp 
where sal >= 3000;
 
 --4) ����
 -- �޿��� 2000�̻��� ����� �˻��ϰ� �޿��� �������� ����
select *
from emp
where sal >= 2000 
order by sal;
 

 --JOB�� �������� �������������ϰ� JOB�� ������ �޿��� �������� ����
select *
from emp
order by job desc, sal asc;

-- ���ǻ���
select empno �����ȣ, ename, job, sal �޿�
from emp
where �޿� > 2000; -- x ��Ī�� �������� ����� �� ����. selection�� projection���� ���� �Ͼ�� ����

select empno �����ȣ, ename, job, sal �޿�
from emp
where sal > 2000
order by �޿�; -- o ��Ī�� ���Ĵ������ ����� �� �ִ�.

select empno �����ȣ, ename, job, sal �޿�
from emp
where sal > 2000
order by 4 desc; -- �� �ε����� ���Ĵ������ ����� �� �ִ�.

select empno �����ȣ, ename, job
from emp
order by sal; -- select ���� ���� �÷��� ������� ������ �� �ִ�. 

select distinct empno �����ȣ, ename, job
from emp
order by sal; -- distinct�� ������� ���� �ݵ�� select ���� ������ �÷��� ��� �����ϴ�.

select empno, ename, sal, comm, sal + comm -- ������ �� �� null�� ������ ����� null�� �ȴ�.
from emp;

-- null���� �ٸ� ������ �����ؼ� ������ �� �ִ�. --> NVL(�÷���, ���氪)
select comm, nvl(comm,0)
from emp;
-----------------------------------------------------------------------------------
/*
  ������ ����
  1) ���������
     +, -, *, / 
     ������ : MOD(��, ������)
     
   2) ���迬����
       > , <, >= , <= , !=
       ����  :  =
       
   3) �񱳿�����
    - AND
    - OR
    - IN :  �÷��� IN (��, ��, ��)  - �ϳ��� �÷��� ������� �Ǵ����� ���Ҷ� ����Ѵ�.
    
    - BETWEEN AND :  �÷��� BETWEEN �ּ� AND �ִ� - �ϳ��� �÷��� ������� �ּ� ~ �ִ븦 ���Ҷ�
    
    - LIKE  : ���ϵ�ī�� ���ڿ� �Բ� ����Ѵ�.
        1. % : 0���̻��� ����
        2. _ : �ѱ���  
        
        EX)  name like 'J%' ;   - NAME�� ù���ڰ� J�� �����ϴ� ��� ����
             name like '___' ;  - NAME�� 3���� 
             name like 'J_J%';  - NAME�� ù���ڰ� J�� �����ϰ� 3��° ���� A�� ���� �˻�
             
             * ���ڿ� �ȿ� % �Ǵ� _�� ���ڷ� �� ���� �� like�� �˻��ϰ� �ʹ�!
              ex) where name like '%#%%' escape '#'
              ex) where name like '%@%%' escape '@'
             
    
    - NOT : ���� ��� �����ڵ� �տ� NOT�� ������ �ݴ� ����.
        
*/
--EX) ��������� : EMP���� ������ = (SAL + COMM) *12  �ؼ� ��� �÷� 
select (sal + comm) * 12 as ���
from emp;
 
 -- * NVL(��, ��ġ��)  : NULL�� ã�� ��ġ������ �����Ѵ�. 
select nvl(comm, 0) as comm
from emp;

--EX) ����� ����ϱ� ���ؼ� COMM�� NULL�� ã�� 0���� �������� �����Ѵ�. - NVL�Լ� ���
select empno, ename, sal, comm, sal + nvl(comm,0) �޿�, (sal + nvl(comm,0)) * 12 ���
from emp;

--EX) ~���� ����� ~ �Դϴ�. ���  : ���ڿ��� �����Ҷ� || ����Ѵ�.
select ename || '���� ����� ' || (sal + nvl(comm,0)) * 12 || '�Դϴ�.' as message
from emp;


--EX) SAL �� 2000 ~ 4000��� �˻�(AND, BETWEEN AND )
select *
from emp
where sal >= 2000 and sal <= 4000;

select *
from emp
where sal between 2000 and 4000;

--EX) SAL �� 2000 ~ 4000����ƴ� ���ڵ� �˻� -  NOT
select *
from emp
where sal not between 2000 and 4000;

--EX) EMPNO �� 7566, 7782,7844�� ����˻� ( OR, IN)
select *
from emp
where empno = 7566 or empno = 7782 or empno = 7844;

select *
from emp
where empno in (7566, 7782, 7844);

--EX) EMPNO �� 7566, 7782,7844�� ����� �ƴ� �˻� ( NOT)
select *
from emp
where empno not in (7566, 7782, 7844);

---------------------------------------------------------------------------
--1) JOB�� 'A' ���ڷν����ϴ� ���ڵ� �˻�
select *
from emp
where job like 'A%';


--2) JOB�� �� ���ڰ� 'N'���� ������ ���ڵ� �˻�
select *
from emp
where job like '%N';

--3) ENAME�� 4������ ���ڵ� �˻�
select *
from emp
where ename like '____';

--4) ENAME�� A���ڰ� ���Ե� ���ڵ� �˻�
select *
from emp
where ename like '%A%';


--5) ENAME��ü ���ڰ� 5�����̰� �ι�° ���ڰ� m�̸鼭�����ڰ� h�� ���ڵ� �˻�
select *
from emp
where ename like upper('_m__h');

-- awarduuu �������� ����
select * from member;
insert into member(id, name, jumin) values('king', 'he%jung', '22222');

-- name�� %��� ���ڿ��� �ִ� ���ڵ带 �˻��ϰ� �ʹ�.
select * from member
where name like '%#%%' escape '#';

------------------------------------------------------------------

/*
NULL ã��
1) IS NULL
2) IS NOT NULL
*/

-- COMM�� NULL�� ���ڵ� �˻�
select * from emp
where comm is not null;

    
--copy_emp���̺��� comm�� null ���ڵ带 comm�� ���� 100���� ����
select * from copy_emp;
commit;
rollback;

update copy_emp 
set comm = 100
where comm is null;

-------------------------------------------------------------------
-- NULL�� �ִ� �÷��� ������� ������ �غ���
select * from emp order by comm asc; -- ���������϶��� null �������� ��ȸ�ȴ�.
select * from emp order by comm asc nulls first; -- nulls first�� �ڿ� �ٿ��ָ� null ó���� ��ȸ�Ѵ�.
select * from emp order by comm desc; -- ���������϶��� null ó���� ��ȸ�ȴ�.
select * from emp order by comm asc nulls last; -- nulls last�� �ڿ� �ٿ��ָ� null �������� ��ȸ�Ѵ�.

-- comm�� ���� ���� �޴� ��� 2�� ��ȸ�ϰ� �ʹ�.
-- table alias�� Ȱ���Ͽ� ��� �÷� projection ���

select rownum, e.*
from emp e
order by comm desc nulls last; -- ������ ���� ���߿� ����Ǳ� ������ rownum�� ������ ���� �ʴ´�.


select e.*
from 
(select * from emp
order by comm desc nulls last) e
where rownum <3;


