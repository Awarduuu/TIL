-----------------------------------------------------
--집계함수

CREATE TABLE REPORT(
 NAME VARCHAR2(20) CONSTRAINT REPORT_NAME_PK PRIMARY KEY,
 BAN CHAR(1),
 KOR NUMBER(3) CHECK(KOR BETWEEN 0 AND 100),
 ENG NUMBER(3) CHECK(ENG BETWEEN 0 AND 100),
 MATH NUMBER(3) CHECK(MATH BETWEEN 0 AND 100)
);

SELECT * FROM REPORT;

--샘플레코드
INSERT INTO REPORT VALUES('희정', 1 , 80, 70,90);
INSERT INTO REPORT VALUES('효리', 1 , 90, 50,90);

INSERT INTO REPORT VALUES('나영', 2 , 100, 65,85);
INSERT INTO REPORT VALUES('재석', 2 , 80, 70, 95);
INSERT INTO REPORT VALUES('희선', 2 , 85, 45,80);

INSERT INTO REPORT VALUES('승기', 3 , 50, 70,70);
INSERT INTO REPORT VALUES('중기', 3 , 90, 75,80);
INSERT INTO REPORT VALUES('혜교', 3 , 70, 90,95);
INSERT INTO REPORT VALUES('미나', 3 , NULL, 80,80);


-- 개인별 국어총점, 국어평균을 검색해보자.
select sum(kor) 국어총점, avg(kor) 국어평균
from report;

-- 국어점수의 최대, 최소, 전체학생수를 검색해보자.
select max(kor) 국어최대, min(kor) 국어최소, count(*) 전체학생수
from report;

--수학점수 최대, 최소, 학생수 ( * | DISTINCT 사용해보자)
select max(math) 국어최대, min(math) 국어최소, count(distinct math), count(math)
from report;


--국어점수의 총점, 평균, NULL을 0으로 변경해서 평균 검색해보자 - AVG()함수는 NULL을 제외한 레코드수로 평균을 구한다. 
select sum(nvl(kor,0)) 국어총점, avg(nvl(kor,0)) 국어평균
from report;

--반별 국어 최대, 최소 총점 평균 인원수 - GROUP BY절에 나온 컬럼은 SELECT절에 집계함수와 함게 사용가능
-- group by로 묶은 컬럼은 select문에서 집계함수와 함께 사용 가능하다.
select ban, max(kor) 국어최대, min(kor) 국어최소, sum(nvl(kor,0)) 국어총점, avg(nvl(kor,0)) 국어평균, count(nvl(kor,0)) 그룹별학생수
from report
group by ban;

-- KOR의 점수가 70이상인 학생들의 반별 국어 최대, 최소 총점 평균 인원수
select ban, max(kor) 국어최대, min(kor) 국어최소, sum(kor) 국어총점, avg(nvl(kor,0)) 국어평균, count(*) 그룹별학생수
from report
where kor >= 70
group by ban;

-- KOR의 평균이 80 이상인 학생들의 반별 국어 최대, 최소 총점 평균 인원수 
select max(kor) 국어최대, min(kor) 국어최소, sum(kor) 국어총점, avg(nvl(kor,0)) 국어평균, count(*) 그룹별학생수
from report
where avg(kor) >= 80 -- 그룹(집계)함수를 조건으로 사용할 때는 where절이 아닌 having절을 이용한다.
group by ban; -- x
-- 실행순서가 where이 group by 보다 먼저이기 때문이다. 

select max(kor) 국어최대, min(kor) 국어최소, sum(kor) 국어총점, avg(nvl(kor,0)) 국어평균, count(*) 그룹별학생수
from report
group by ban
having avg(kor) >=80;



/*
  중요!!
 SELECT   5)
 FROM     1)
 WHERE    2)
 GROUP BY 3)
 HAVING   4)
 ORDER BY 6)

*/

SELECT DEPTNO, SUM(SAL)
FROM EMP
GROUP BY DEPTNO
HAVING SUM(SAL) > 10000 AND DEPTNO IN (20 ,30);

SELECT DEPTNO, SUM(SAL)
FROM EMP
WHERE DEPTNO IN (20 ,30)
GROUP BY DEPTNO
HAVING SUM(SAL) > 10000 ;


-----------------------------------------------
SELECT BAN , SUM(KOR) 총점
FROM REPORT
WHERE KOR >=70
GROUP BY rollup(BAN); -- 소계 + 총계


SELECT BAN , SUM(KOR) 총점
FROM REPORT
WHERE KOR >=70
GROUP BY CUBE(BAN);

SELECT BAN , SUM(KOR) 총점
FROM REPORT
WHERE KOR >=70
GROUP BY GROUPING SETS(BAN);


---------------------------------------
/*
 ROLLUP VS CUBE VS GROUPING SETS
*/
CREATE TABLE MONTHLY_SALES( --월별매출
  GOODS_ID VARCHAR2(5), --상품아이디
  MONTH VARCHAR2(10), -- 월
  COMPANY VARCHAR2(20), --회사
  SALES_AMOUNT NUMBER -- 매출금액
);

INSERT INTO MONTHLY_SALES VALUES('P01','2023-01', '롯데', 15000);
INSERT INTO MONTHLY_SALES VALUES('P01','2023-02', '롯데', 25000);

INSERT INTO MONTHLY_SALES VALUES('P02','2023-01', '삼성', 8000);
INSERT INTO MONTHLY_SALES VALUES('P02','2023-02', '삼성', 12000);


INSERT INTO MONTHLY_SALES VALUES('P03','2023-01', 'LG', 8500);
INSERT INTO MONTHLY_SALES VALUES('P03','2023-02', 'LG', 13000);

SELECT * FROM MONTHLY_SALES;

SELECT GOODS_ID , SUM(SALES_AMOUNT)
FROM MONTHLY_SALES
GROUP BY ROLLUP(GOODS_ID); -- 총계 함께 출력 

SELECT MONTH , SUM(SALES_AMOUNT)
FROM MONTHLY_SALES
GROUP BY ROLLUP(MONTH);


SELECT GOODS_iD, MONTH , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY ROLLUP(GOODS_iD,MONTH); -- ROLLUP 첫번째 나온 컬럼을 기준으로 소계, 전체 (인수의 순서가 중요)

SELECT MONTH , GOODS_iD  , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY ROLLUP(MONTH , GOODS_iD);

--CUBE
SELECT GOODS_iD, MONTH , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY CUBE(GOODS_iD,MONTH); -- CUBE 소계부분을 각 컬럼을 기준으로 나오기때문에서 인수의 순서가 상관없다. 

SELECT  MONTH , GOODS_ID, SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY CUBE(MONTH , GOODS_ID);


--GROUPING SETS
SELECT GOODS_iD, MONTH , SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY GROUPING SETS(GOODS_iD,MONTH);

SELECT  MONTH , GOODS_ID, SUM(SALES_AMOUNT) 총매출액
FROM MONTHLY_SALES
GROUP BY GROUPING SETS(MONTH ,GOODS_iD);
