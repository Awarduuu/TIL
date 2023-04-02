
--WS03

--1. 계좌 ( account ) 테이블을 조회하되, 고객명 ( name ) 도 함께 조회한다. ( 단, ANSI JOIN 을 사용 )
select u.name, a.* 
from users u join account a
on u.user_seq = a.user_seq;

--2. 위 1번 query 를 table alias 를 사용하고, 오라클 Join 표기법을 사용한다.
select u.name, a.* 
from users u, account a
where u.user_seq = a.user_seq;

--3. 고객번호 ( user_seq ) 가 111 인 고객의 계좌 중 잔고 ( balance ) 가 2000 이상 계좌 ( account ) 테이블을 조회하되, 고객번호, 고객명, 계좌번호, 잔고 순으로 조회한다.
select u.user_seq, u.name, a.account_number, a.balance
from users u join account a
on u.user_seq = a.user_seq
where a.user_seq = 111 and a.balance >= 2000;

--4. 계좌 ( account ) 테이블의 잔고 ( balance ) 가 5000 이상인 고객의 고객번호 ( user_seq ), 고객명 ( name ), 잔고 ( balance ) 를 조회한다. ( 단 Subquery 를 사용하지 않고 join 으로만 작성 )
select u.user_seq, u.name, a.balance
from users u right join account a
on u.user_seq = a.user_seq
where a.balance >= 5000;

--5. 위 4번 문제를 Subquery 를 이용해서 작성한다.
select u.user_seq, u.name, a.balance
from users u, (select * from account where balance >= 5000) a
where u.user_seq = a.user_seq;

--6. 고객 ( users ) 테이블에서 고객번호 ( user_seq ), 고객명 ( name ) 조회하되, 고객명 뒤에 계좌의 수도 account_cnt 로 함께 조회한다. ( 단, 계좌가 없는 고객은 제외한다. )
select u.user_seq, u.name, count(a.account_seq) account_cnt
from users u inner join (select * from account where account_seq is not null) a
on u.user_seq = a.user_seq
group by (u.user_seq, u.name);

--7. 위 6번 문제를 조회하되 계좌가 없는 고객도 함께 조회하고 계좌의 수에 0 으로 표시한다.
select u.user_seq, u.name, count(a.account_seq) account_cnt
from users u left join (select * from account where account_seq is not null) a
on u.user_seq = a.user_seq
group by (u.user_seq, u.name);

--8. 각 계좌별 잔고 ( balance ) 가 전체 평균 잔고보다 적은 고객의 고객번호 ( user_seq ), 고객명 ( name ) 을 조회한다.
select distinct u.user_seq, u.name
from users u join account a
on u.user_seq = a.user_seq
where balance > (select avg(nvl(balance,0)) from account);

--9. 고객의 잔고의 합이 전체 평균 잔고 + 5000 이하인 고객의 고객번호 ( user_seq ), 고객명 ( name ) 을 조회한다.
select user_seq, name
from users
where user_seq in (select user_seq
from account 
group by user_seq
having sum(balance) < (select avg(nvl(balance,0)) + 5000 from account));

--10. 계좌 ( account ) 테이블에서 balance 기준 내림차순으로 정렬하되, 상위 5 건만 조회한다.
select *
from (select * from account
order by balance desc nulls last)
where rownum <= 5;

--11. salary 가 10000 이상인 사원의 employee_id, first_name, last_name, salary, job_title, department_name 을 조회한다.
select e.employee_id, e.first_name, e.last_name, e.salary, j.job_title, d.department_name
from employees e join jobs j using(job_id) 
join departments d using(department_id);

--12. job_id 가 IT_PROG 인 사원의 평균 salary 보다 salary 가 더 많은 사원의 총 수를 구한다.
select count(*) 총수
from employees
where salary > (select avg(salary)
from employees
where job_id = 'IT_PROG');

--13. 입사일자가 '97/06/25' 이후 입사한 사원 중 부서의 최소 salary 가 8000 이상고 부서의 최대 salary 가 20000 이하 인 부서에 해당하는 사원 전체를 조회한다.
select * 
from employees
where hire_date >= to_date('97/06/25', 'YYYY-MM-DD') and
department_id in (
select department_id
from employees
group by department_id
having max(salary) <= 20000 and min(salary) >= 8000);

--14. manager_id 가 108 인 department 소속 사원들의 평균 salary 를 구하여, department_id, department_avg_salary 로 조회한다.
select department_id, avg(salary) department_avg_salary
from employees
where manager_id = 108
group by department_id;

--15. manager_id 가 없는 사원이 manager 로 등록되어 있는 사원의 employee_id, first_name, last_name, salary, job_title 조회한다.
select e.employee_id, e.first_name, e.last_name, e.salary, j.job_title
from employees e join jobs j
using(job_id)
where e.manager_id = (select employee_id from employees where manager_id is null);


