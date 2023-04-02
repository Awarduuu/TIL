
--WS03

--1. ���� ( account ) ���̺��� ��ȸ�ϵ�, ���� ( name ) �� �Բ� ��ȸ�Ѵ�. ( ��, ANSI JOIN �� ��� )
select u.name, a.* 
from users u join account a
on u.user_seq = a.user_seq;

--2. �� 1�� query �� table alias �� ����ϰ�, ����Ŭ Join ǥ����� ����Ѵ�.
select u.name, a.* 
from users u, account a
where u.user_seq = a.user_seq;

--3. ����ȣ ( user_seq ) �� 111 �� ���� ���� �� �ܰ� ( balance ) �� 2000 �̻� ���� ( account ) ���̺��� ��ȸ�ϵ�, ����ȣ, ����, ���¹�ȣ, �ܰ� ������ ��ȸ�Ѵ�.
select u.user_seq, u.name, a.account_number, a.balance
from users u join account a
on u.user_seq = a.user_seq
where a.user_seq = 111 and a.balance >= 2000;

--4. ���� ( account ) ���̺��� �ܰ� ( balance ) �� 5000 �̻��� ���� ����ȣ ( user_seq ), ���� ( name ), �ܰ� ( balance ) �� ��ȸ�Ѵ�. ( �� Subquery �� ������� �ʰ� join ���θ� �ۼ� )
select u.user_seq, u.name, a.balance
from users u right join account a
on u.user_seq = a.user_seq
where a.balance >= 5000;

--5. �� 4�� ������ Subquery �� �̿��ؼ� �ۼ��Ѵ�.
select u.user_seq, u.name, a.balance
from users u, (select * from account where balance >= 5000) a
where u.user_seq = a.user_seq;

--6. �� ( users ) ���̺��� ����ȣ ( user_seq ), ���� ( name ) ��ȸ�ϵ�, ���� �ڿ� ������ ���� account_cnt �� �Բ� ��ȸ�Ѵ�. ( ��, ���°� ���� ���� �����Ѵ�. )
select u.user_seq, u.name, count(a.account_seq) account_cnt
from users u inner join (select * from account where account_seq is not null) a
on u.user_seq = a.user_seq
group by (u.user_seq, u.name);

--7. �� 6�� ������ ��ȸ�ϵ� ���°� ���� ���� �Բ� ��ȸ�ϰ� ������ ���� 0 ���� ǥ���Ѵ�.
select u.user_seq, u.name, count(a.account_seq) account_cnt
from users u left join (select * from account where account_seq is not null) a
on u.user_seq = a.user_seq
group by (u.user_seq, u.name);

--8. �� ���º� �ܰ� ( balance ) �� ��ü ��� �ܰ��� ���� ���� ����ȣ ( user_seq ), ���� ( name ) �� ��ȸ�Ѵ�.
select distinct u.user_seq, u.name
from users u join account a
on u.user_seq = a.user_seq
where balance > (select avg(nvl(balance,0)) from account);

--9. ���� �ܰ��� ���� ��ü ��� �ܰ� + 5000 ������ ���� ����ȣ ( user_seq ), ���� ( name ) �� ��ȸ�Ѵ�.
select user_seq, name
from users
where user_seq in (select user_seq
from account 
group by user_seq
having sum(balance) < (select avg(nvl(balance,0)) + 5000 from account));

--10. ���� ( account ) ���̺��� balance ���� ������������ �����ϵ�, ���� 5 �Ǹ� ��ȸ�Ѵ�.
select *
from (select * from account
order by balance desc nulls last)
where rownum <= 5;

--11. salary �� 10000 �̻��� ����� employee_id, first_name, last_name, salary, job_title, department_name �� ��ȸ�Ѵ�.
select e.employee_id, e.first_name, e.last_name, e.salary, j.job_title, d.department_name
from employees e join jobs j using(job_id) 
join departments d using(department_id);

--12. job_id �� IT_PROG �� ����� ��� salary ���� salary �� �� ���� ����� �� ���� ���Ѵ�.
select count(*) �Ѽ�
from employees
where salary > (select avg(salary)
from employees
where job_id = 'IT_PROG');

--13. �Ի����ڰ� '97/06/25' ���� �Ի��� ��� �� �μ��� �ּ� salary �� 8000 �̻�� �μ��� �ִ� salary �� 20000 ���� �� �μ��� �ش��ϴ� ��� ��ü�� ��ȸ�Ѵ�.
select * 
from employees
where hire_date >= to_date('97/06/25', 'YYYY-MM-DD') and
department_id in (
select department_id
from employees
group by department_id
having max(salary) <= 20000 and min(salary) >= 8000);

--14. manager_id �� 108 �� department �Ҽ� ������� ��� salary �� ���Ͽ�, department_id, department_avg_salary �� ��ȸ�Ѵ�.
select department_id, avg(salary) department_avg_salary
from employees
where manager_id = 108
group by department_id;

--15. manager_id �� ���� ����� manager �� ��ϵǾ� �ִ� ����� employee_id, first_name, last_name, salary, job_title ��ȸ�Ѵ�.
select e.employee_id, e.first_name, e.last_name, e.salary, j.job_title
from employees e join jobs j
using(job_id)
where e.manager_id = (select employee_id from employees where manager_id is null);


