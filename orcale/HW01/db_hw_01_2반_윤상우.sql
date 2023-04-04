--1. job_id 가 'IT_PROG' 인 employees 테이블을 조회한다.
select *
from employees
where job_id = 'IT_PROG';

--2. salary 가 5000 이상 인 employees 테이블을 조회한다..
select *
from employees
where salary >= 5000;

--3. salary 가 5000 이상 10000 이하 인 employees 테이블을 조회한다.
select *
from employees
where salary between 5000 and 10000;

--4. last_name 이 'M' 으로 시작하는 employees 테이블 중 employee_id, first_name, last_name, email 을 조회한다.
select employee_id, first_name, last_name, email
from employees
where last_name like 'M%';

--5. email 에 'AN' 을 포함하는 employees 테이블 중 employee_id, first_name, last_name, email 을 조회한다.
select employee_id, first_name, last_name, email
from employees
where email like '%AN%';

--6. employees 테이블에 있는 job_id 를 중복없이 조회한다.
select distinct job_id
from employees;

--7. manager_id 가 없는 ( null ) employees 테이블을 조회한다.
select *
from employees
where manager_id is null;

--8. commission_pct 가 있는 employees 테이블을 조회한다
select *
from employees
where commission_pct is not null;

--9. job_id 가 'FI_ACCOUNT' 또는 'IT_PROG' 이고, salary 가 8000 이상 인 employees 테이블을 조회한다.
select *
from employees
where job_id in ('FI_ACCOUNT', 'IT_PROG') and salary >= 8000;

--10. employees 테이블을 salary 기준으로 오름차순으로 정렬하여 조회한다.
select *
from employees
order by salary;

--11. employees 테이블을 job_id 기준으로 오름차순으로, 그리고 그 안에서 salary 기준으로 내림차순으로 정렬하여 조회한다.
select *
from employees
order by job_id, salary desc;

--12. employees 테이블에서 employee_id, email, salary, commission_pct을 조회하되, commission_pct 값이 없으면 0 으로 표시한다.
select employee_id, email, salary, nvl(commission_pct,0) commission_pct
from employees;

--13. employees 테이블을 employee_id, first_name, last_name 을 조회하되, first_name 과 last_name 을 합쳐서 (중간에 공백문자 1개 포함) fullname 으로 조회한다.
select employee_id, first_name, last_name, first_name || ' ' || last_name fullname
from employees;

--14. employees 테이블을 employee_id, first_name, last_name 을 조회하되, last_name 의 길이가 5 이하인 건만 조회한다.
select employee_id, first_name, last_name
from employees
where length(last_name) <= 5;

--15. employees 테이블에서 salary 가 5000 이상인 건수를 조회하고 high_salary_cnt 로 표시한다.
select count(*) high_salary_cnt
from employees
where salary >= 5000;

--16. employees 테이블에서 job_id 가 'IT_PROG' 인 조건에 해당하는 salary 의 전체 합을 구하고 it_prog_salary_sum 으로 표시한다.
select sum(salary) it_prog_salary_sum
from employees
where job_id = 'IT_PROG';

--17. employees 테이블에서 hire_date가 가장 빠른 값과 가장 늦은 값을 구하고 각각 hire_date_min, hire_date_max 로 표시한다.
select min(hire_date) hire_date_min, max(hire_date) hire_date_max
from employees;

--18. employees 테이블에서 job_id 와 job_id 별 employee 건수를 조회하고 job_id_employee_cnt 로 표시한다.
select job_id, count(*) job_id_employee_cnt
from employees
group by job_id;

--19. employees 테이블에서 department_id별 salary 의 합을 조회하고 department_id_salary_sum 로 표시한다. 단, department_id 가 없는 건은 제외한다.
select sum(salary) department_id_salary_sum
from employees
group by department_id
having department_id is not null;

--20. 위 19번의 결과 중 department_id_salary_sum 이 50000 이하인 건만을 조회한다.

select *
from (select sum(salary) department_id_salary_sum
from employees
group by department_id
having department_id is not null)
where department_id_salary_sum <= 50000;


select u.user_seq, u.name, a.account_number, a.balance 
	   from account a, users u 
	   where a.user_seq = u.user_seq 
	   and u.name like '%길동'