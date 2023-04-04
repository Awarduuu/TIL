--1. job_id �� 'IT_PROG' �� employees ���̺��� ��ȸ�Ѵ�.
select *
from employees
where job_id = 'IT_PROG';

--2. salary �� 5000 �̻� �� employees ���̺��� ��ȸ�Ѵ�..
select *
from employees
where salary >= 5000;

--3. salary �� 5000 �̻� 10000 ���� �� employees ���̺��� ��ȸ�Ѵ�.
select *
from employees
where salary between 5000 and 10000;

--4. last_name �� 'M' ���� �����ϴ� employees ���̺� �� employee_id, first_name, last_name, email �� ��ȸ�Ѵ�.
select employee_id, first_name, last_name, email
from employees
where last_name like 'M%';

--5. email �� 'AN' �� �����ϴ� employees ���̺� �� employee_id, first_name, last_name, email �� ��ȸ�Ѵ�.
select employee_id, first_name, last_name, email
from employees
where email like '%AN%';

--6. employees ���̺� �ִ� job_id �� �ߺ����� ��ȸ�Ѵ�.
select distinct job_id
from employees;

--7. manager_id �� ���� ( null ) employees ���̺��� ��ȸ�Ѵ�.
select *
from employees
where manager_id is null;

--8. commission_pct �� �ִ� employees ���̺��� ��ȸ�Ѵ�
select *
from employees
where commission_pct is not null;

--9. job_id �� 'FI_ACCOUNT' �Ǵ� 'IT_PROG' �̰�, salary �� 8000 �̻� �� employees ���̺��� ��ȸ�Ѵ�.
select *
from employees
where job_id in ('FI_ACCOUNT', 'IT_PROG') and salary >= 8000;

--10. employees ���̺��� salary �������� ������������ �����Ͽ� ��ȸ�Ѵ�.
select *
from employees
order by salary;

--11. employees ���̺��� job_id �������� ������������, �׸��� �� �ȿ��� salary �������� ������������ �����Ͽ� ��ȸ�Ѵ�.
select *
from employees
order by job_id, salary desc;

--12. employees ���̺��� employee_id, email, salary, commission_pct�� ��ȸ�ϵ�, commission_pct ���� ������ 0 ���� ǥ���Ѵ�.
select employee_id, email, salary, nvl(commission_pct,0) commission_pct
from employees;

--13. employees ���̺��� employee_id, first_name, last_name �� ��ȸ�ϵ�, first_name �� last_name �� ���ļ� (�߰��� ���鹮�� 1�� ����) fullname ���� ��ȸ�Ѵ�.
select employee_id, first_name, last_name, first_name || ' ' || last_name fullname
from employees;

--14. employees ���̺��� employee_id, first_name, last_name �� ��ȸ�ϵ�, last_name �� ���̰� 5 ������ �Ǹ� ��ȸ�Ѵ�.
select employee_id, first_name, last_name
from employees
where length(last_name) <= 5;

--15. employees ���̺��� salary �� 5000 �̻��� �Ǽ��� ��ȸ�ϰ� high_salary_cnt �� ǥ���Ѵ�.
select count(*) high_salary_cnt
from employees
where salary >= 5000;

--16. employees ���̺��� job_id �� 'IT_PROG' �� ���ǿ� �ش��ϴ� salary �� ��ü ���� ���ϰ� it_prog_salary_sum ���� ǥ���Ѵ�.
select sum(salary) it_prog_salary_sum
from employees
where job_id = 'IT_PROG';

--17. employees ���̺��� hire_date�� ���� ���� ���� ���� ���� ���� ���ϰ� ���� hire_date_min, hire_date_max �� ǥ���Ѵ�.
select min(hire_date) hire_date_min, max(hire_date) hire_date_max
from employees;

--18. employees ���̺��� job_id �� job_id �� employee �Ǽ��� ��ȸ�ϰ� job_id_employee_cnt �� ǥ���Ѵ�.
select job_id, count(*) job_id_employee_cnt
from employees
group by job_id;

--19. employees ���̺��� department_id�� salary �� ���� ��ȸ�ϰ� department_id_salary_sum �� ǥ���Ѵ�. ��, department_id �� ���� ���� �����Ѵ�.
select sum(salary) department_id_salary_sum
from employees
group by department_id
having department_id is not null;

--20. �� 19���� ��� �� department_id_salary_sum �� 50000 ������ �Ǹ��� ��ȸ�Ѵ�.

select *
from (select sum(salary) department_id_salary_sum
from employees
group by department_id
having department_id is not null)
where department_id_salary_sum <= 50000;


select u.user_seq, u.name, a.account_number, a.balance 
	   from account a, users u 
	   where a.user_seq = u.user_seq 
	   and u.name like '%�浿'