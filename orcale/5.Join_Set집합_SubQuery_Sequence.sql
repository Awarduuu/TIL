/*
  JOIN
   : 한번의 SELECT문장의로 2개 이상의 테이블에 있는 컬럼의 정보를 검색하고 싶을때 사용한다.
   : JOIN의 종류
     1) INNER JOIN
         - EQUI JOIN = 동등조인 = NATURAL JOIN
         - NON EQUI JOIN : 조인 대상 테이블의 어떤 컬럼의 값도 일치하지 않을때 사용
                          EX) BETWEEN AND , IS NULL, IS NOT NULL, IN, > , < 등의 이런 조건문을 사용할때 쓴다.
        
      2) OUTER JOIN
           : 기본 EQUI JOIN을 하면서 별도의 테이블의 모든 정보를 검색하고 싶을때.
              - LEFT OUTER JOIN
              - RIGHT OUTER JOIN
              - FULL OUTER JOIN
    
      3) SELF JOIN
           : 자기 자신테이블을 조인하는 것(하나의 테이블을 2개처럼 사용하는 것)
           : 주로 재귀적관계일 때 많이 사용한다. (재귀적관계란 자신자신테이블의 PK를 FK로 참조하는 것)
           
    : JOIN 코딩 방법
      1) SQL JOIN  - FULL OUTER JOIN은 제공하지 않는다. 
      2) ANSI JOIN : 미국국립표준연구소에서 정한 미국의 표준을 기본으로 한다. - 권장
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

-- test1을 참조하는 테이블 생성 (id에 해당하는 사람이 갖고 있는 job과 sal 정보)
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


-- id, name, job, sal 검색하고 싶다. -> join
-------------------------------------------------------------------------------
-- sql 조인방식
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id = t2.id; -- 동등 조인

-- outer join : 기본은 동등조인이면서 한쪽 테이블의 모든 레코드를 검색하고 싶을때
-- 1) left outer join
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id = t2.id(+);

-- 2) right outer join
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id(+) = t2.id;

-- 3) full outer join : sql 조인 방식에서는 지원 안함 --> ansi 조인방식으로 해결하자!
select t1.id, name, job, sal
from test1 t1, test2 t2
where t1.id = t2.id;

--------------------------------------------------------------------------------
-- ansi 조인방식
select *
from test1 inner join test2
on test1.id = test2.id;

select *
from test1 join test2 -- inner 생략 가능
on test1.id = test2.id;

select t1.id, name, job, sal
from test1 t1 join test2 t2 -- inner 생략 가능
on t1.id = t2.id;

--using절 사용하기 : 조인조건의 대상이 되는 컬럼의 이름이 동일할때는 on절 대신에 using 사용한다.
select *
from test1 join test2 -- inner 생략 가능
using(id); -- 공통 컬럼인 id 한번만 나오니까 alias 필요 없음 -> 특수한 경우에 사용하면 좋을듯

--natural join -- 조인을 하는 테이블에서 같은 컬럼명, 같은 타입을 갖는 컬럼을 기준으로 모두 조인을 해준다.
select *
from test1 natural join test2;

--outer join
--1) left outer join
select id, name, job, sal
from test1 left join test2 -- inner 생략 가능
using(id);

--2) right outer join
select id, name, job, sal
from test1 right join test2 -- inner 생략 가능
using(id);

--3) full outer join
select id, name, job, sal
from test1 full join test2 -- inner 생략 가능
using(id);

create table test3(
    code char(3) primary key references test2(code),
    manager_name varchar2(30),
    phone varchar2(30)
);

insert into test3 values('a01', 'jae', '111-1111');
insert into test3 values('a02', 'song', '222-2222');
insert into test3 values('a03', 'hyo', '333-3333');

-- ex) id, name, addr, job, sal, manager_name, phone 검색

-- sql 조인방식
select test2.id, name, addr, job, sal, manager_name, phone
from test1, test2, test3
where test1.id = test2.id and test2.code = test3.code;

-- ansi 조인방식
select *
from test1 join test2
using(id) join test3
using(code);

-- 조인에 조건 넣기 - sal > 300

-- sql 조인방식
select test1.id, name, addr, job, sal, manager_name, phone
from test1, test2, test3
where test1.id = test2.id and test2.code = test3.code and sal >= 300;

-- ansi 조인방식
select *
from test1 join test2
using(id) join test3
using(code)
where sal >= 300;

-- non equal join : emp테이블에서 사원정보 + 급여등급을 함께 검색하고 싶다.
select empno, ename, job, sal, grade
from emp join salgrade
on sal between losal and hisal order by sal;

-- self join : 자기 자신 테이블을 2개로 만들어서 조인 (재귀적관계)
select * from emp;

-- ex) ___사원의 관리자는 ___입니다
select e1.ename || '사원의 관리자는 ' || e2.ename || '입니다'
from emp e1 join emp e2 -- e1은 사원테이블, e2는 관리자테이블 -> self join은 alias 필수
on e1.mgr = e2.empno; -- 사원에서는 관리자를 관리자에서는 사원을 공통 컬럼으로 설정


--------------------------------------------------------------
/*
  SET 집합
   1) 합집합
        UNION ALL - 중복레코드를포함
        UNION - 중복레코드 제외
        
   2) 교집합 
       INTERSECT : A와 B 테이블의 공통된 레코드 검색
       
   3) 차집합 
        MINUS : A테이블에서 B테이블이 레코드를 뺀 나머지 레코드 검색

 -------------------------------------------------------------
 /*
   SUBQUERY - 부질의
    : 메인쿼리안에 또 다른 쿼리가 존재하는것
    : ()괄호로 묶는다. 괄호안에 실행문장이 먼저 실행된후 그 결과를 메인쿼리의 조건으로 주로 사용한다. 
    : 서브쿼리의 결과 행이 한개 일때  비교연산자 사용.
    : 서브쿼리의 결과 행이 여러개 일때는 ANY, ALL, IN 연산자를 사용한다. 
    : 주로 SELECT에서 많이 사용하지만 CREATE, INSERT, UPDATE ,DELTE, 
           HAVING, WHERE , FROM ,ORDER 에서도 사용가능하다.
 */
 --EMP테이블에서 평균 급여보다 더 많이 받는 사원 검색

select * from emp
where sal > (select avg(sal) from emp);
      
-- JOB에 'A'문자열이 들어간 사원의 부서와 같은 곳에서 근무하는 사원의 부서이름 검색하고 싶다. 
-- 서브쿼리의 결과레코드가 다중행이므로 다중행 함수(in, all, any)를 써야 함 (단일행 함수인 = 사용 못함)

select dname
from dept 
where deptno in (select distinct deptno from emp where job like '%A%');
     
-- 부서번호가 30인 사원들이 급여중에서 가장 많이 받는 사원보다 더 많이 받는 사원정보를 검색하고 싶다. 
select *
from emp
where sal > all(select sal from emp where deptno = 30);

select *
from emp
where sal > (select max(sal) from emp where deptno = 30);


-- SUBQUERY를 INSERT
select * from copy_emp;
delete from copy_emp;
commit;

insert into copy_emp (select * from emp where sal > 2000);

-- 특정한 컬럼만 다른테이블로부터 가져와서 insert한다.
insert into copy_emp (empno, ename, job, sal)(select empno, ename, job, sal from emp where deptno=20);


--SUBQUERY를 UPDATE
   --EX) EMP테이블에서 EMPNO 7900인 사원의 JOB, MGR, DEPTNO로 SUB_EMP테이블의 7566의 사원의 정보로 수정해보자.
update copy_emp
set (job, mgr, deptno) = (select job,mgr,deptno from emp where empno=7900)
where empno = 7566;

--SUBQUERY를 DELETE
   --EX) EMP테이블이 평균 급여를 조건으로 사용해서 평균급여보다 많이 받는 사원들을 삭제한다. 
delete
from copy_emp
where sal < (select avg(sal) from emp);

-- 상호 연관 서브 쿼리, main쿼리 alias 필수 
select /* + hint */empno, ename, sal, deptno
from emp e
where sal > (select avg(sal) from emp where deptno = e.deptno)
order by deptno;

--------------------------------------------------------------
/*
  SUBQUERY 종류중의 하나인 인라인뷰
   : FROM절 뒤에 서브쿼리가 오는 것.
*/

-- 급여를 기준으로 정렬해서 ROWNUM을 함께 출력하고 싶다.
SELECT ROWNUM, EMPNO, ENAME, JOB, SAL 
FROM EMP 
ORDER BY SAL DESC; -- 정렬을 한 결과를 테이블처럼 사용하면서 ROWNUM 이용해야한다.

--1) 먼저 정렬한다.
SELECT * FROM EMP ORDER BY SAL DESC;

SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) ;--인라인뷰

-- ROWNUM을 대상으로 조건을 만들어보자 .
--1. ROWUM이 3보다 작은 레코드 검색
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM < 3;

--2. ROWUM이 3보다 큰 레코드 검색
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM > 3; --X

--3. ROWUM이 5 ~ 7 사이 레코드 검색
SELECT ROWNUM, ENAME, JOB, SAL
FROM (SELECT * FROM EMP ORDER BY SAL DESC) 
WHERE ROWNUM BETWEEN 5 AND 7 ; --X

/*
  ROWNUM은 레코드가 만들어지면서 번호가 순차적으로 부여되는 것을 ROWNUM 1 이 없으면 2를 실행할수 없다. 
  그래서 ROWNUM를 조건으로  ~ 크다  또는 중간범위를 직접 조건으로 사용할수없다.
  ROWNUM을 미리 다 부여된 결과를 조건으로 사용해야한다. 
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
  SEQUENCE : 자동 증가 값 설정
    :생성방법
      CREATE SEQUENCE 시퀀스이름
      [START WITH 초기값]
      [INCREMENT BY 증가값]
      [MAXVALUE 최댓값]
      [MINVALUE 최솟값]
      [CACHE | NOCACHE]
      [CYCLE | NOCYCLE]
      
    : 사용방법
      시퀀스이름.NEXTVAL : 시퀀스를 증가
      시퀀스이름.CURRVAL : 시퀀스의 현재값 가져오기
       
    : 시퀀스 수정
    ALTER SEQUENCE 시퀀스이름;
    
    : 시퀀스 삭제
    DROP SEQUENCE 시퀀스이름;
*/

create table board(
    bno number primary key,
    subject varchar2(20),
    reg_date date default sysdate
)

--글번호에 적용할 시퀀스를 생성해보자
create sequence board_bno_seq;
drop sequence board_bno_seq;

select board_bno_seq.nextval, board_bno_seq.currval
from dual;

--테이블에 insert하면서 시퀀스 사용해보자
insert into board(bno, subject) values (board_bno_seq.nextval, '제목');

select * from board;