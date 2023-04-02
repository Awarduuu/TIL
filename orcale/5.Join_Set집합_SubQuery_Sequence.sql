/*
  JOIN
   : �ѹ��� SELECT�����Ƿ� 2�� �̻��� ���̺� �ִ� �÷��� ������ �˻��ϰ� ������ ����Ѵ�.
   : JOIN�� ����
     1) INNER JOIN
         - EQUI JOIN = �������� = NATURAL JOIN
         - NON EQUI JOIN : ���� ��� ���̺��� � �÷��� ���� ��ġ���� ������ ���
                          EX) BETWEEN AND , IS NULL, IS NOT NULL, IN, > , < ���� �̷� ���ǹ��� ����Ҷ� ����.
        
      2) OUTER JOIN
           : �⺻ EQUI JOIN�� �ϸ鼭 ������ ���̺��� ��� ������ �˻��ϰ� ������.
              - LEFT OUTER JOIN
              - RIGHT OUTER JOIN
              - FULL OUTER JOIN
    
      3) SELF JOIN
           : �ڱ� �ڽ����̺��� �����ϴ� ��(�ϳ��� ���̺��� 2��ó�� ����ϴ� ��)
           : �ַ� ����������� �� ���� ����Ѵ�. (���������� �ڽ��ڽ����̺��� PK�� FK�� �����ϴ� ��)
           
    : JOIN �ڵ� ���
      1) SQL JOIN  - FULL OUTER JOIN�� �������� �ʴ´�. 
      2) ANSI JOIN : �̱�����ǥ�ؿ����ҿ��� ���� �̱��� ǥ���� �⺻���� �Ѵ�. - ����
*/

create table test1(
id varchar2(10) primary key,
name varchar2(30),
addr varchar2(50)
);

insert into test1 values('1', 'anna', 'seoul');
insert into test1 values('2', 'betty', 'busan');
insert into test1 values('3', 'cathy', 'daegu');
insert into test1 values('4', 'diana', 'daejeon');
insert into test1 values('5', 'emily', 'jeju');

-- test1�� �����ϴ� ���̺� ���� (id�� �ش��ϴ� ����� ���� �ִ� job�� sal ����)
create table test2(
    code char(3) primary key,
    id varchar2(10) references test1(id), -- fk
    job varchar2(30),
    sal number(3)
);

insert into test2 values('a01', '1', 'teacher', 200);
insert into test2 values('a02', '1', 'programmer', 300);
insert into test2 values('a03', '2', 'student', 100);
insert into test2 values('a04', '3', 'designer', 250);
insert into test2 values('a05', null, 'manager', 400);


-- id, name, job, sal �˻��ϰ� �ʹ�. -> join
-------------------------------------------------------------------------------
-- sql ���ι��
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id = t2.id; -- ���� ����

-- outer join : �⺻�� ���������̸鼭 ���� ���̺��� ��� ���ڵ带 �˻��ϰ� ������
-- 1) left outer join
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id = t2.id(+);

-- 2) right outer join
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id(+) = t2.id;

-- 3) full outer join : sql ���� ��Ŀ����� ���� ���� --> ansi ���ι������ �ذ�����!
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id = t2.id;

--------------------------------------------------------------------------------
-- ansi ���ι��
select *
from test1 inner join test2
on test1.id = test2.id;

select *
from test1 join test2 -- inner ���� ����
on test1.id = test2.id;

select t1.id, name, job, sal
from test1 t1 join test2 t2 -- inner ���� ����
on t1.id = t2.id;

--using�� ����ϱ� : ���������� ����� �Ǵ� �÷��� �̸��� �����Ҷ��� on�� ��ſ� using ����Ѵ�.
select *
from test1 join test2 -- inner ���� ����
using(id); -- ���� �÷��� id �ѹ��� �����ϱ� alias �ʿ� ���� -> Ư���� ��쿡 ����ϸ� ������

--natural join -- ������ �ϴ� ���̺��� ���� �÷���, ���� Ÿ���� ���� �÷��� �������� ��� ������ ���ش�.
select *
from test1 natural join test2;

--outer join
--1) left outer join
select id, name, job, sal
from test1 left join test2 -- inner ���� ����
using(id);

--2) right outer join
select id, name, job, sal
from test1 right join test2 -- inner ���� ����
using(id);

--3) full outer join
select id, name, job, sal
from test1 full join test2 -- inner ���� ����
using(id);

create table test3(
    code char(3) primary key references test2(code),
    manager_name varchar2(30),
    phone varchar2(30)
);

insert into test3 values('a01', 'jae', '111-1111');
insert into test3 values('a02', 'song', '222-2222');
insert into test3 values('a03', 'hyo', '333-3333');

-- ex) id, name, addr, job, sal, manager_name, phone �˻�

-- sql ���ι��
select test2.id, name, addr, job, sal, manager_name, phone
from test1, test2, test3
where test1.id = test2.id and test2.code = test3.code;

-- ansi ���ι��
select *
from test1 join test2
using(id) join test3
using(code);

-- ���ο� ���� �ֱ� - sal > 300

-- sql ���ι��
select test1.id, name, addr, job, sal, manager_name, phone
from test1, test2, test3
where test1.id = test2.id and test2.code = test3.code and sal >= 300;

-- ansi ���ι��
select *
from test1 join test2
using(id) join test3
using(code)
where sal >= 300;

-- non equal join : emp���̺��� ������� + �޿������ �Բ� �˻��ϰ� �ʹ�.
select empno, ename, job, sal, grade
from emp join salgrade
on sal between losal and hisal order by sal;

-- self join : �ڱ� �ڽ� ���̺��� 2���� ���� ���� (���������)
select * from emp;

-- ex) ___����� �����ڴ� ___�Դϴ�
select e1.ename || '����� �����ڴ� ' || e2.ename || '�Դϴ�'
from emp e1 join emp e2 -- e1�� ������̺�, e2�� ���������̺� -> self join�� alias �ʼ�
on e1.mgr = e2.empno; -- ��������� �����ڸ� �����ڿ����� ����� ���� �÷����� ����


--------------------------------------------------------------
/*
  SET ����
   1) ������
        UNION ALL - �ߺ����ڵ带����
        UNION - �ߺ����ڵ� ����
        
   2) ������ 
       INTERSECT : A�� B ���̺��� ����� ���ڵ� �˻�
       
   3) ������ 
        MINUS : A���̺��� B���̺��� ���ڵ带 �� ������ ���ڵ� �˻�

 -------------------------------------------------------------
 /*
   SUBQUERY - ������
    : ���������ȿ� �� �ٸ� ������ �����ϴ°�
    : ()��ȣ�� ���´�. ��ȣ�ȿ� ���๮���� ���� ������� �� ����� ���������� �������� �ַ� ����Ѵ�. 
    : ���������� ��� ���� �Ѱ� �϶�  �񱳿����� ���.
    : ���������� ��� ���� ������ �϶��� ANY, ALL, IN �����ڸ� ����Ѵ�. 
    : �ַ� SELECT���� ���� ��������� CREATE, INSERT, UPDATE ,DELTE, 
           HAVING, WHERE , FROM ,ORDER ������ ��밡���ϴ�.
 */
 --EMP���̺��� ��� �޿����� �� ���� �޴� ��� �˻�

select * from emp
where sal > (select avg(sal) from emp);
      
-- JOB�� 'A'���ڿ��� �� ����� �μ��� ���� ������ �ٹ��ϴ� ����� �μ��̸� �˻��ϰ� �ʹ�. 
-- ���������� ������ڵ尡 �������̹Ƿ� ������ �Լ�(in, all, any)�� ��� �� (������ �Լ��� = ��� ����)

select dname
from dept 
where deptno in (select distinct deptno from emp where job like '%A%');
     
-- �μ���ȣ�� 30�� ������� �޿��߿��� ���� ���� �޴� ������� �� ���� �޴� ��������� �˻��ϰ� �ʹ�. 
select *
from emp
where sal > all(select sal from emp where deptno = 30);

select *
from emp
where sal > (select max(sal) from emp where deptno = 30);


-- SUBQUERY�� INSERT
select * from copy_emp;
delete from copy_emp;
commit;

insert into copy_emp (select * from emp where sal > 2000);

-- Ư���� �÷��� �ٸ����̺�κ��� �����ͼ� insert�Ѵ�.
insert into copy_emp (empno, ename, job, sal)(select empno, ename, job, sal from emp where deptno=20);


--SUBQUERY�� UPDATE
   --EX) EMP���̺��� EMPNO 7900�� ����� JOB, MGR, DEPTNO�� SUB_EMP���̺��� 7566�� ����� ������ �����غ���.
update copy_emp
set (job, mgr, deptno) = (select job,mgr,deptno from emp where empno=7900)
where empno = 7566;

--SUBQUERY�� DELETE
   --EX) EMP���̺��� ��� �޿��� �������� ����ؼ� ��ձ޿����� ���� �޴� ������� �����Ѵ�. 
delete
from copy_emp
where sal < (select avg(sal) from emp);

-- ��ȣ ���� ���� ����, main���� alias �ʼ� 
select /* + hint */empno, ename, sal, deptno
from emp e
where sal > (select avg(sal) from emp where deptno = e.deptno)
order by deptno;

--------------------------------------------------------------
/*
  SUBQUERY �������� �ϳ��� �ζ��κ�
   : FROM�� �ڿ� ���������� ���� ��.
*/

-- �޿��� �������� �����ؼ� ROWNUM�� �Բ� ����ϰ� �ʹ�.
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL 
FROM EMP 
ORDER BY SAL DESC; -- ������ �� ����� ���̺�ó�� ����ϸ鼭 ROWNUM �̿��ؾ��Ѵ�.

--1) ���� �����Ѵ�.
SELECT * FROM EMP ORDER BY SAL DESC;

SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) ;--�ζ��κ�

-- ROWNUM�� ������� ������ ������ .
--1. ROWUM�� 3���� ���� ���ڵ� �˻�
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM < 3;

--2. ROWUM�� 3���� ū ���ڵ� �˻�
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM > 3; --X

--3. ROWUM�� 5 ~ 7 ���� ���ڵ� �˻�
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM BETWEEN 5 AND 7 ; --X

/*
  ROWNUM�� ���ڵ尡 ��������鼭 ��ȣ�� ���������� �ο��Ǵ� ���� ROWNUM 1 �� ������ 2�� �����Ҽ� ����. 
  �׷��� ROWNUM�� ��������  ~ ũ��  �Ǵ� �߰������� ���� �������� ����Ҽ�����.
  ROWNUM�� �̸� �� �ο��� ����� �������� ����ؾ��Ѵ�. 
*/
SELECT * FROM 
    (SELECT ROWNUM NO, ENAME, JOB, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC) )
WHERE NO >3 ; 

SELECT * FROM 
    (SELECT ROWNUM NO, ENAME, JOB, SAL
    FROM (SELECT * FROM EMP ORDER BY SAL DESC) )
WHERE NO BETWEEN 5 AND 7 ;




----------------------------------------------------------
/*
  SEQUENCE : �ڵ� ���� �� ����
    :�������
      CREATE SEQUENCE �������̸�
      [START WITH �ʱⰪ]
      [INCREMENT BY ������]
      [MAXVALUE �ִ�]
      [MINVALUE �ּڰ�]
      [CACHE | NOCACHE]
      [CYCLE | NOCYCLE]
      
    : �����
      �������̸�.NEXTVAL : �������� ����
      �������̸�.CURRVAL : �������� ���簪 ��������
       
    : ������ ����
    ALTER SEQUENCE �������̸�;
    
    : ������ ����
    DROP SEQUENCE �������̸�;
*/

create table board(
    bno number primary key,
    subject varchar2(20),
    reg_date date default sysdate
)

--�۹�ȣ�� ������ �������� �����غ���
create sequence board_bno_seq;
drop sequence board_bno_seq;

select board_bno_seq.nextval, board_bno_seq.currval
from dual;

--���̺� insert�ϸ鼭 ������ ����غ���
insert into board(bno, subject) values (board_bno_seq.nextval, '����');

select * from board;