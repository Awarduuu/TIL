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


--------------------------------------------------------------
/*
  SET 집합
   1) 합집합
        UNION ALL - 중복레코드를포함
        UNION - 중복레코드 제외
        
   2) 교집합 
       INSERSECT : A와 B 테이블의 공통된 레코드 검색
       
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
  
      
-- JOB에 'A'문자열이 들어간 사원의 부서와 같은 곳에서 근무하는 사원의 부서이름 검색하고 싶다. 
  
     
 -- 부서번호가 30인 사원들이 급여중에서 가장 많이 받는 사원보다 더 많이 받는 사원정보를 검색하고 싶다. 
  


-- SUBQUERY를 INSERT


--SUBQUERY를 UPDATE
   --EX) EMP테이블에서 EMPNO 7900인 사원의 JOB, MGR, DEPTNO로 SUB_EMP테이블의 7566의 사원의 정보로 수정해보자.


--SUBQUERY를 DELETE
   --EX) EMP테이블이 평균 급여를 조건으로 사용해서 평균급여보다 많이 받는 사원들을 삭제한다. 


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


