/*
   SELECT문장 - DQL문장
    : 구조
    select distinct | * | 컬럼명 as 별칭, 컬럼명 별칭,....   : 열을 제한 :PROJECTION
    from 테이블이름     
    [where 조건식 ]  : 레코드(튜플)제한  - SELECTION
    [order by 컬럼명 desc | asc , .. ] -정렬
    
    
    * distinct 는 중복레코드를 제거
    * AS 는 컬럼에 별칭 만들기 
    * 실행순서
      SELECT   3) 
      FROM     1)
      WHERE    2) 
      ORDER BY 4) 
    
*/

--EX) SCOTT계정 접속 

SELECT * FROM EMP; --사원테이블
SELECT * FROM DEPT;--부서정보테이블

--1) EMP테이블에서 원하는 컬럼(별칭)
select empno as 사원번호, ename as 이름, hiredate as 고용날짜, job as 직무, sal as 급여
from emp;

--2) 중복행 제거하기 - DISTINCT
 --EX) 우리회사에 어떤 JOB있는지 JOB의 종류를 알고싶다!!!
select distinct job as 직업
from emp;
 
--3) 조건 만들기 
 -- 급여가 3000이상인 사원 검색
select *
from emp 
where sal >= 3000;
 
 --4) 정렬
 -- 급여가 2000이상인 사원을 검색하고 급여를 기준으로 정렬
select *
from emp
where sal >= 2000 
order by sal;
 

 --JOB을 기준으로 내림차순정렬하고 JOB이 같으면 급여를 기준으로 정렬
select *
from emp
order by job desc, sal asc;

-- 주의사항
select empno 사원번호, ename, job, sal 급여
from emp
where 급여 > 2000; -- x 별칭을 조건으로 사용할 수 없다. selection이 projection보다 먼저 일어나기 때문

select empno 사원번호, ename, job, sal 급여
from emp
where sal > 2000
order by 급여; -- o 별칭을 정렬대상으로 사용할 수 있다.

select empno 사원번호, ename, job, sal 급여
from emp
where sal > 2000
order by 4 desc; -- 열 인덱스를 정렬대상으로 사용할 수 있다.

select empno 사원번호, ename, job
from emp
order by sal; -- select 절에 없는 컬럼을 대상으로 정렬할 수 있다. 

select distinct empno 사원번호, ename, job
from emp
order by sal; -- distinct를 사용했을 때는 반드시 select 절에 나오는 컬럼만 사용 가능하다.

select empno, ename, sal, comm, sal + comm -- 연산을 할 때 null이 있으면 결과가 null이 된다.
from emp;

-- null값을 다른 값으로 변경해서 연산할 수 있다. --> NVL(컬럼명, 변경값)
select comm, nvl(comm,0)
from emp;
-----------------------------------------------------------------------------------
/*
  연산자 종류
  1) 산술연산자
     +, -, *, / 
     나머지 : MOD(값, 나눌수)
     
   2) 관계연산자
       > , <, >= , <= , !=
       같다  :  =
       
   3) 비교연산자
    - AND
    - OR
    - IN :  컬럼명 IN (값, 값, 값)  - 하나의 컬럼을 대상으로 또는으로 비교할때 사용한다.
    
    - BETWEEN AND :  컬럼명 BETWEEN 최소 AND 최대 - 하나의 컬럼을 대상으로 최소 ~ 최대를 비교할때
    
    - LIKE  : 와일드카드 문자와 함께 사용한다.
        1. % : 0개이상의 문자
        2. _ : 한글자  
        
        EX)  name like 'J%' ;   - NAME에 첫글자가 J로 시작하는 모든 문자
             name like '___' ;  - NAME이 3글자 
             name like 'J_J%';  - NAME의 첫글자가 J로 시작하고 3번째 글자 A인 정보 검색
             
             * 문자열 안에 % 또는 _가 문자로 들어가 있을 때 like로 검색하고 싶다!
              ex) where name like '%#%%' escape '#'
              ex) where name like '%@%%' escape '@'
             
    
    - NOT : 위의 모든 연산자들 앞에 NOT을 붙히면 반대 개념.
        
*/
--EX) 산술연산자 : EMP에서 년봉계산 = (SAL + COMM) *12  해서 년봉 컬럼 
select (sal + comm) * 12 as 년봉
from emp;
 
 -- * NVL(값, 대치값)  : NULL을 찾아 대치값으로 변경한다. 
select nvl(comm, 0) as comm
from emp;

--EX) 년봉을 계산하기 위해서 COMM의 NULL을 찾아 0으로 변경한후 연산한다. - NVL함수 사용
select empno, ename, sal, comm, sal + nvl(comm,0) 급여, (sal + nvl(comm,0)) * 12 년봉
from emp;

--EX) ~님의 년봉은 ~ 입니다. 출력  : 문자열을 연결할때 || 사용한다.
select ename || '님의 년봉은 ' || (sal + nvl(comm,0)) * 12 || '입니다.' as message
from emp;


--EX) SAL 가 2000 ~ 4000사원 검색(AND, BETWEEN AND )
select *
from emp
where sal >= 2000 and sal <= 4000;

select *
from emp
where sal between 2000 and 4000;

--EX) SAL 가 2000 ~ 4000사원아닌 레코드 검색 -  NOT
select *
from emp
where sal not between 2000 and 4000;

--EX) EMPNO 가 7566, 7782,7844인 사원검색 ( OR, IN)
select *
from emp
where empno = 7566 or empno = 7782 or empno = 7844;

select *
from emp
where empno in (7566, 7782, 7844);

--EX) EMPNO 가 7566, 7782,7844인 사원이 아닌 검색 ( NOT)
select *
from emp
where empno not in (7566, 7782, 7844);

---------------------------------------------------------------------------
--1) JOB에 'A' 문자로시작하는 레코드 검색
select *
from emp
where job like 'A%';


--2) JOB에 끝 끌자가 'N'으로 끝나는 레코드 검색
select *
from emp
where job like '%N';

--3) ENAME이 4글자인 레코드 검색
select *
from emp
where ename like '____';

--4) ENAME에 A글자가 포함된 레코드 검색
select *
from emp
where ename like '%A%';


--5) ENAME전체 글자가 5글자이고 두번째 글자가 m이면서끝글자가 h인 레코드 검색
select *
from emp
where ename like upper('_m__h');

-- awarduuu 계정으로 접속
select * from member;
insert into member(id, name, jumin) values('king', 'he%jung', '22222');

-- name에 %라는 문자열이 있는 레코드를 검색하고 싶다.
select * from member
where name like '%#%%' escape '#';

------------------------------------------------------------------

/*
NULL 찾기
1) IS NULL
2) IS NOT NULL
*/

-- COMM이 NULL인 레코드 검색
select * from emp
where comm is not null;

    
--copy_emp테이블에서 comm이 null 레코드를 comm의 값을 100으로 변경
select * from copy_emp;
commit;
rollback;

update copy_emp 
set comm = 100
where comm is null;

-------------------------------------------------------------------
-- NULL이 있는 컬럼을 대상으로 정렬을 해보자
select * from emp order by comm asc; -- 오름차순일때는 null 마지막에 조회된다.
select * from emp order by comm asc nulls first; -- nulls first를 뒤에 붙여주면 null 처음에 조회한다.
select * from emp order by comm desc; -- 내림차순일때는 null 처음에 조회된다.
select * from emp order by comm asc nulls last; -- nulls last를 뒤에 붙여주면 null 마지막에 조회한다.

-- comm을 가장 많이 받는 사원 2명 조회하고 싶다.
-- table alias를 활용하여 모든 컬럼 projection 방법

select rownum, e.*
from emp e
order by comm desc nulls last; -- 정렬이 가장 나중에 실행되기 때문에 rownum은 정렬이 되지 않는다.


select e.*
from 
(select * from emp
order by comm desc nulls last) e
where rownum <3;


