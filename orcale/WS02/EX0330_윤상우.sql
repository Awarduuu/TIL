insert into users (user_seq, name, email, phone) values (444, '��浿', 'sa@gildong@com', '010-4444-4444');
insert into users (user_seq, name, email, phone) values (555, '���浿', 'o@gildong@com', '010-5555-5555');



CREATE TABLE account
( 
    account_seq   NUMBER,
    account_number VARCHAR2(50) not null,
    balance       NUMBER,
    user_seq      NUMBER,
	CONSTRAINT account_pk PRIMARY KEY (account_seq)
);

insert into account (account_seq, account_number, balance, user_seq) values (50, '00500505005005', 3000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (10, '00100101001001', 1000, 111);
insert into account (account_seq, account_number, balance, user_seq) values (30, '00300303003003', 5000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (70, '00700707007007', 7000, 444);
insert into account (account_seq, account_number, balance, user_seq) values (40, '00400404004004', 4000, 222);
insert into account (account_seq, account_number, balance, user_seq) values (60, '00600606006006', 2000, 222);
insert into account (account_seq, account_number) values (80, '00800808008008');
insert into account (account_seq, account_number, balance, user_seq) values (20, '00200202002002', 6000, 111);

SELECT * FROM USERS;
SELECT * FROM ACCOUNT;

COMMIT;

-- EX0330_�����.sql�� ����
-- WS02 14������

--1. ����ȣ ( user_seq ) �� 111 �� ���� ( account ���̺��� ��ȸ�Ѵ�
select *
from account
where user_seq = 111;

--2. �ܰ� ( balance ) �� 5000 �̸��� ���� ( account ) ���̺��� ��ȸ�Ѵ�
select *
from account
where balance < 5000;

--3. �ܰ� ( balance ) �� 5000 �̻� 10000 ������ ���� ( account ) ���̺��� ��ȸ�Ѵ�
select *
from account
where balance between 5000 and 10000;

--4. ���¹�ȣ ( accountNumber �� ��4�� �� �����ϴ� ���� ( account ���̺��� ��ȸ�Ѵ�
select *
from account
where to_char(account_number) like '%4%' ;

--5. ���� ( name �� �� �� �� �����ϴ� �� ( users ) ���̺��� ��ȸ�Ѵ�
select *
from users
where name like '��%';

--6. ���� ( account ) ���̺� �ִ� �� ��ȣ ( user_seq ) �� �ߺ����� ��ȸ�Ѵ�

select distinct user_seq
from account;

--7. �ܰ� ( balance ) �� ���� ( null ) ���� ( account ) ���̺��� ��ȸ�Ѵ�
select *
from account
where balance is null;

--8. ����ȣ ( user_seq ) �� �ִ� ���� ( account ���̺��� ��ȸ�Ѵ�
select *
from account
where user_seq is not null;

--9. ����ȣ ( user_seq ) �� �ְ� , �ܰ� 4000 ������ ���� ( account ���̺��� 
select *
from account
where user_seq is not null and balance <= 4000;

--10. ���� ( account ) ���̺��� ����ȣ ( user_seq ) �������� ������������ �����Ͽ� ��ȸ�Ѵ�
select *
from account
order by user_seq;

--11. ���� ( account ) ���̺��� ����ȣ ( user_seq ) �������� ������������ , �׸��� �� �ȿ��� �ܰ� ( balance ) �������� ������������ �����Ͽ� ��ȸ�Ѵ�
select *
from account
order by user_seq, balance desc;

--12. ���� ( account ) ���̺��� ��ȸ�ϵ� , balance ���� ������ 0 ���� ǥ���Ѵ�
select account_seq, account_number, nvl(balance,0) balance, user_seq
from account;

--13. �� ( users ) ���̺��� ��ȸ�ϵ� , email �� ���� �� �κ��� ���� �� ���̵� ǥ���Ѵ� . �÷��� email ��� email_id �� �����Ѵ�
select user_seq, name, substr(email,1,instr(email,'@')-1) email_id, phone
from users;

--14. �� ( users ) ���̺��� ��ȸ�ϵ� , phone �� ����--�� �� �����ϰ� ǥ���Ѵ� . �÷��� phone_short �� �����Ѵ�
select user_seq, name, email, replace(phone, '-', '') phone_short
from users;

--���ڰ��� �����Ѵ�.
drop table emp;


--emp ���̺� ����
Create Table emp(
	emp_id 	   NUMBER, --�����ȣ
	emp_name	   Varchar2(20) Not Null,  --����̸�
	job      	               Varchar2(20) Not Null,  --����
	dept_id  	  NUMBER, --�μ���ȣ
	sal 	              NUMBER Not Null,--�޿�
	bonus	              NUMBER,--���ʽ�
	mgr_id	              NUMBER,--�����ڹ�ȣ
	hiredate             date  Not Null, --�Ի���
	constraint emp_id_pk Primary Key(emp_id) --��������
);



--�����ͻ���

INSERT INTO EMP VALUES (6200,'��ö��','��ǥ�̻�',200,  5000,NULL,NULL, '1997-12-17');

INSERT INTO EMP VALUES (6311,'�����','����',100, 3500,Null,6200, '1998-12-17');

INSERT INTO EMP VALUES (7489,'�ε���','������',400,  1850,200,6321, '1999-02-27') ;

INSERT INTO EMP VALUES (7522,'����ö','������',400, 1850,300,6321,'1998-02-28') ;

INSERT INTO EMP VALUES (6321,'������','����',400, 3800,500,6200,'1999-04-20') ;

INSERT INTO EMP VALUES (6351,'������','����',300,   2850,NULL,6200,'2000-05-31'); 

INSERT INTO EMP VALUES (7910,'�̿���','�渮',300, 1000,NULL,6351,'2001-05-01');

INSERT INTO EMP VALUES (6361,'��ö��','����',200, 3200,NULL,6200,'2000-06-09') ;

INSERT INTO EMP VALUES (7878,'����','������',200, 3000,NULL,6361,'2001-06-05') ;

INSERT INTO EMP VALUES (7854,'������','������',400, 1500,0,6321,'2001-09-08') ;

INSERT INTO EMP VALUES (7872,'�̹���','�繫��',100, 1500,NULL,6311,'2001-02-12') ;

INSERT INTO EMP VALUES (7920,'�踶����','�繫��',300, 1050,NULL,6351,'2001-03-18');

INSERT INTO EMP VALUES (7901,'������','������',NULL, 3000,NULL,NULL,'2001-12-03'); 

INSERT INTO EMP VALUES (7933,'��ö��','�繫��',200,  1050,NULL,6361,'2002-01-02');


SELECT * FROM EMP;


-----------------------------------------------------------------------------
 /* emp_id - �����ȣ, emp_name - ����̸�, job - ������, dept_id - �μ���ȣ
   sal ,- �޿�, bonus - ���ʽ�,  mgr_id - �����ڹ�ȣ , hiredate - �Ի���*/

--1. emp ���̺��� �� ��� emp_name�� �޿�(sal)�� 100�� ���� �� 12�� ���� ���� ��µǵ���  select���� ������� ����غ�����.(��Ī- ��� )
select emp_name, (sal + 100) ���
from emp;

--2.������ job�� �������� ��� ����� �̸�(emp_name), ������(job),�μ���ȣ(dept_id)�� �˻��� ������.
select emp_name, job, dept_id
from emp
where job = '������';

--3.�Ի���(hiredate)�� ��2001��12��3�ϡ��� ��� ����� �˻� �ϼ���.

select *
from emp
where hiredate = '2001-12-3';

--4.�μ���ȣ(dept_id)�� 200�� �μ����� �ٹ��ϴ� ��� ����� �̸��� ������,�Ի���,�μ���ȣ�˻��ϼ���.

select emp_name, job, hiredate, dept_id
from emp
where dept_id = 200;

--5.emp���̺��� �޿��� 3000�̻� 5000������ ��� ����� �̸��� �޿��� ����ϼ���.

select emp_name, sal
from emp
where sal between 3000 and 5000;

--6.emp���̺��� �����ڹ�ȣ(mgr_id)�� 6311,6361,6351��� �ϳ��� ��� ����� �����ȣ,�����ڹ�ȣ,�̸�,�μ���ȣ�� ����ϼ���.
select emp_id, mgr_id, emp_name, dept_id
from emp
where mgr_id in (6311,6361,6351);

--7.�������� �繫���̰ų� �渮�� ����� ��� ������ �˻��ϼ���.
select *
from emp
where job in ('�繫��', '�渮');

--8.emp���̺��� �޿��� 3000�̻��� ��� ������ ������ �˻��ϼ���.
select *
from emp
where sal >= 3000 and job = '����';

--9. emp���̺��� �������� ������ �̰ų� �繫���� �ƴ� ��� ����� ������ �˻��ϼ���.
select *
from emp
where job = '������' or job != '�繫��';

--10. emp���̺��� �޿��� 1500�̻� 2500���ϰ�  �ƴ� ��� ����� ������ �˻��ϼ���.
select *
from emp
where sal not between 1500 and 2500;

--11.�������� �渮�̰ų� �����̸鼭 �޿��� 3000�� �Ѵ� ��� ����� ������ �˻��ϰ� ������� �Ի��� ������� ����ϼ���.
select *
from emp
where job in ('�渮', '����') and sal >= 3000
order by hiredate;

--12.����� �μ���ȣ�� �������� ������������ �����ϵ�, ���� �μ� �ȿ����� �޿��� ���� ����� ���� ��� �ǵ��� �ϼ���.
select *
from emp
order by dept_id, sal desc;

--13.���ʽ�(bonus)�� null�� �ƴϸ鼭 �Ի����� 2000�� �̻��� ����� ������ �˻��ϼ���.
select *
from emp
where bonus is not null and extract(year from hiredate)>= 2000;

--14.emp_name�� 3�����̰� �� ���ڰ� ����'�̸� ù���ڴ� ���ڡ����� �����ϴ� ����� �����˻��ϼ���.
select *
from emp
where emp_name like '��_��';

--15. ���ʽ�(bonus)�� null�� ����� ���ʽ��� 0���� �����ϼ���.
update emp set bonus = 0 
where bonus is null;

--16. ������ �����������鼭 �޿��� 2000~3000���� �� ����� �̸��� ���嵿�ǡ�, �޿��� 3500���� �����ϼ���.
update emp set emp_name = '�嵿��', sal = 3500
where job like '%��' and sal between 2000 and 3000;

--17. emp_name�� ��ö���ڰ� ���鼭 ������ ������ ����� ������ �����ϼ���.
delete from emp 
where emp_name like '%ö%' and job = '����';

--18.���̺��� �����ϼ���. 
drop table emp;                        







