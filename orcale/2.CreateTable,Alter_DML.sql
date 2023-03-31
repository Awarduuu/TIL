-- 각자의 계정으로 접속한다. conn 계정명/비번

/*
  Datatype의 종류
  1) 문자열   
      CHAR(BYTE수) : 고정길이 - 최대 2000 BYTE
      VARCHAR2(BYTE수) : 가변길이 -최대 4000 BYTE
      
      *유니코드를 지원!!
      NCHAR(BYTE수)
      NVARCHAR2(BYTE수)
      
      * 반드시 문자는 '값'  형식으로 사용한다.
      * ORACLE에서 요즘 UTF-8 인코딩으로 한글자는 3BYTE이다!!
      
        EX) CHAR(6) : 한글 2자, 영문은 6글자
            VARCHAR2(6) : 한글 2자, 영문은 6글자
            
      * CHAR(6 CHAR) : BYTE와 관계없이 6글자까지
        VARCHAR2(6 CHAR) : BYTE와 관계없이 6글자까지
        
      * 대용량의 데이터을 저장해야하는경우 
       LOB : LARGE OBJECT 약자로 대용량의 데이터를 저장할수 있는 데이터 타입 
         1) CLOB : 가변길의 아주 긴 문자열을 저장할때 4GB
         2) BLOB :  가변길의 2진수 형태를 저장할때 4GB
        - LOB타입은 권장하지는 않는다
        
    
  2) 숫자
     : NUMBER
       SMALLINT
       INT
       
       * SMALLINT 또는 INT를 선언해도 결국 내부적으로  NUMBER 타입으로 된다. 
         - 정수형, 실수형 표현
         EX) NUMBER(1) : 정수 -9 ~ 9 표현
             NUMBER(2) : -99 ~ 99 
             
             NUMBER(5,3) : 전체 5자리에서 3자리가 소수점자리.
  
  
  3) 날짜
     : DATE : 년월일 시분초 설정
       TIMESTAMP : 년월일 시분초 + MILS 단위까지 더 정밀하게 표현!!!
      
      *날짜는 반드시 '년-월-일' 형식으로 묶어서 사용한다.
      * 현재 날짜와시간을 구하는 함수 SYSDATE 사용한다.
        EX) SELECT SYSDATE FROM DUAL;
*/


/*
  -테이블 생성
  create table 테이블이름(
    컬럼명 datatype [default 기본값] [ null | not null ] [ constraint 별칭 제약조건 ] ,
    컬럼명 datatype [default 기본값] [ null | not null ] [ constraint 별칭 제약조건 ] ,
    .....
)

  - 제약조건의 종류
   1) PRIMARY KEY : 대표키, 중복X, NOT NULL
   2) FOREIGN KEY :다른 테이블의 컬럼을 참조
   3) UNIQUE : PK유사(테이블에서 대표키는 될수 없는 그렇지만 유일해야하는 속성에 설정) 
   4) CHECK : DOMAIN에 들어갈수 있는 값을 범위를 체크
   
   5) DEFAULT  : 기본값 설정

*/
/*
   1) PRIMARY KEY - PK, 기본키, 대표키
      : PK를 설정하면 중복안됨, NOT NULL , 자동의로 INDEX설정 - EX) 학번, 군번, 주민번호, 상품코드,...아이디...
      : PK는 하나의 테이블에 반드시 한개만 존재
      : 2개의 이상의 컬럼을 하나로 묶어서 PK설정 가능 
          - 복합키설정 : 사용할때 불편해서 모델링 과정속에서 복합키를 대리키로 변환하는 경우 많다!!!
*/

--EX) 테이블 생성
CREATE TABLE MEMBER(
  ID VARCHAR2(20) CONSTRAINT MEMBER_ID_PK PRIMARY KEY ,
  NAME VARCHAR2(10) NOT NULL,
  JUMIN CHAR(13) ,
  AGE NUMBER(2) , -- -99 ~ 99
  ADDR VARCHAR2(10 CHAR) ,
  REG_DATE DATE
);

--테이블 검색
SELECT * FROM MEMBER;

--테이블 구조
DESC MEMBER;


/*
  레코드 등록
  INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
  INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
*/

INSERT INTO MEMBER VALUES('JANG','장희정','1111',20,'서울','2022-1-20');
INSERT INTO MEMBER(ID,NAME) VALUES('HEE','나영');

--중복
INSERT INTO MEMBER(ID,NAME) VALUES('HEE','효리');--X

INSERT INTO MEMBER(ID,NAME) VALUES('hee','효리'); --데이터는 대소문자 다르다.  

INSERT INTO MEMBER(NAME) VALUES('효리'); --X

INSERT INTO MEMBER(ID,NAME) VALUES('AA','소녀시대'); --X
INSERT INTO MEMBER(ID,NAME,ADDR) VALUES('BB','소희','서울시 강남구 도곡'); --O

INSERT INTO MEMBER(ID,NAME,ADDR) VALUES('CC','소희','서울시 강남구 도곡22'); --X

INSERT INTO MEMBER(ID,NAME, AGE) VALUES('DD','소희',100);  --X
INSERT INTO MEMBER(ID,NAME, AGE) VALUES('DD','소희',99);
INSERT INTO MEMBER(ID,NAME, AGE) VALUES('FF','소희',-99);

INSERT INTO MEMBER(ID,NAME, REG_DATE) VALUES('EE','효민',SYSDATE);

--레코드 검색
SELECT * FROM MEMBER;


--char vs varchar2 비교
INSERT INTO MEMBER(ID, NAME, JUMIN) VALUES('GG','A','B');

INSERT INTO MEMBER(ID, NAME, JUMIN) VALUES('TT','A ','B ');


--VARCHAR2 비교 
SELECT * FROM MEMBER WHERE NAME ='A ';

-- CHAR 비교
SELECT * FROM MEMBER WHERE JUMIN ='B ';
---------------------------------------------------------
/*
  테이블 삭제
  DROP TABLE 테이블이름;
*/
DROP TABLE MEMBER;

/*
  두개의 컬럼을 하나로 묶어서 PK설정 - 복합키
*/
CREATE TABLE MEMBER(
  ID VARCHAR2(20) ,
  NAME VARCHAR2(10) NOT NULL,
  JUMIN CHAR(13) ,
  AGE NUMBER(2) ,
  ADDR VARCHAR2(10 CHAR) ,
  REG_DATE DATE ,
  CONSTRAINT MEM_ID_JUMIN_PK PRIMARY KEY(ID,JUMIN)
);

SELECT * FROM MEMBER;
DESC MEMBER;
--레코드 삽입
INSERT INTO MEMBER VALUES('JANG','희정','11111',15, NULL ,SYSDATE);

INSERT INTO MEMBER(ID,JUMIN , NAME) VALUES('JANG','22222','나영');

INSERT INTO MEMBER(ID,JUMIN , NAME) VALUES('HEE','22222','나영');

INSERT INTO MEMBER(ID,JUMIN , NAME) VALUES('JANG','22222','나영'); --X
----------------------------------------------------------------------------
/*
  2) FOREIGN KEY - FK = 외래키
      : 다른 테이블의 PK를 참조하는 것.
      : 테이블에 레코드를 추가할때 참조되는 대상의 값이외에는 등록 할수 없다.
          - 참조무결성원칙!!!
      : NULL허용, 중복가능!!
      : 하나의 테이블에 여러개의 컬럼이 FK설정가능하다.
      
      : 재귀적관계 설계 - 자기자신테이블의 PK를 참조하는것!!!
      
      *주의사항
        INSERT 할때 : 부모키가 INSERT -> 자식 INSERT 
        DELETE할때 :  참조하고 있는 자식 DELETE -> 부모 DELETE 해야한다.
      
             * 이러한 주의사항에 대한 불편함을 해결하기 위해서.
               FK를 설정할때 ON DELETE CASCADE 를 추가하면 부모레코드를 삭제하를
              그 부모키를 참조하는 모든 테이블의 레코드를 함께 삭제한다.
	      또는 FK설정할때 on delete set null 를 추가하면
	      부모레코드 삭제될때 참조되는 자식레코드의 값이 null이된다.
      
     
*/
SELECT * FROM EMP


--EX) 부서테이블을 생성
CREATE TABLE DEPT(
  DEPT_CODE CHAR(3) CONSTRAINT DEPT_CODE_PK  PRIMARY KEY,
  DNAME VARCHAR2(30) NOT NULL,
  LOC VARCHAR2(50)
);

--레코드 삽입
INSERT INTO DEPT VALUES('A01','경리부','서울');
INSERT INTO DEPT VALUES('A02','교육부','대구');
INSERT INTO DEPT VALUES('A03','전산부','서울');

--EX) 사원테이블 생성
CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --기본값설정
);


SELECT * FROM DEPT;
SELECT * FROM EMP;

INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE)VALUES(100,'장희정',3000,'A01');

INSERT INTO EMP VALUES(200,'이효리',1500,'A01',NULL);

INSERT INTO EMP VALUES(300,'이미선',200,NULL , DEFAULT);

INSERT INTO EMP VALUES(400,'삼순이',2000, 'A04' , DEFAULT); --X 오류

--DEPT테이블에서 참조되지 않는 부서코드를 삭제해본다.
DELETE FROM DEPT WHERE DEPT_CODE='A03'; --성공

DELETE FROM DEPT WHERE DEPT_CODE='A01'; -- x(먼저 자식레코드 삭제후, 부모레코드 삭제가능)

DELETE FROM EMP WHERE DEPT_CODE='A01'; --자식 삭제
DELETE FROM DEPT WHERE DEPT_CODE='A01'; --부모 삭제 


DROP TABLE EMP;
DROP TABLE DEPT;
--ON DELETE CASCADE VS  on delete set null

-- ON DELETE CASCADE  TEST
CREATE TABLE DEPT(
  DEPT_CODE CHAR(3) CONSTRAINT DEPT_CODE_PK  PRIMARY KEY,
  DNAME VARCHAR2(30) NOT NULL,
  LOC VARCHAR2(50)
);

--레코드 삽입
INSERT INTO DEPT VALUES('A01','경리부','서울');
INSERT INTO DEPT VALUES('A02','교육부','대구');
INSERT INTO DEPT VALUES('A03','전산부','서울');

--EX) 사원테이블 생성
CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE CASCADE ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --기본값설정
);

INSERT INTO EMP VALUES(200,'이효리',1500,'A01',NULL);
INSERT INTO EMP VALUES(300,'장희정',1500,'A01',NULL);
INSERT INTO EMP VALUES(400,'장희정',1500,'A02',NULL);

SELECT * FROM DEPT;
SELECT * FROM EMP;

--참조되고 있는 부모키 레코드를 삭제해본다.
DELETE FROM DEPT WHERE DEPT_CODE='A01';


DROP TABLE EMP;
--on delete set null TEST
CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) on delete set null ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --기본값설정
);

INSERT INTO EMP VALUES(200,'이효리',1500,'A02',NULL);
INSERT INTO EMP VALUES(300,'장희정',1500,'A02',NULL);
INSERT INTO EMP VALUES(400,'장희정',1500,'A03',NULL);

DELETE FROM DEPT WHERE DEPT_CODE='A02';

--삭제!!!!!
/*
   레코드 삭제방법
    1) ROLLBACK 처리가능 - DML
      DELETE [FROM] 테이블이름
      [WHERE 조건식]
      
        * FROM 생략가능, WHERE절이 없으면 모든 레코드가 삭제된다.
          
    2) ROLLBACK 안된다. - DDL
     TRUNCATE TABLE 테이블이름; --모든레코드를 삭제
      
*/
--현재 상황을 모두 저장완료
COMMIT;

SELECT * FROM EMP;
DELETE FROM EMP; --모든레코드 삭제

ROLLBACK;

TRUNCATE TABLE EMP;

-- DEPT에서 교육부를 삭제해본다.
DELETE DEPT WHERE DEPT_CODE='A02'; --O
SELECT * FROM DEPT;

--DEPT에서 교육부를 삭제해본다.
DELETE DEPT WHERE DEPT_CODE='A01'; --X

--참조되고 있는 자식레코드를 삭제하고 부모레코드를 삭제한다.
DELETE EMP WHERE DEPT_CODE='A01';
DELETE DEPT WHERE DEPT_CODE='A01';


ROLLBACK
-- 위 절차가 복잡해서 FK를 설정할때 ON DELETE CASCADE 옵션을 준다.
SELECT * FROM DEPT;
SELECT * FROM EMP;

DROP TABLE EMP;

CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE CASCADE,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --기본값설정
);

SELECT * FROM EMP;
SELECT * FROM DEPT;

DELETE DEPT WHERE DEPT_CODE='A01';

--외래키를 생성할때 맨뒤에 작성하기!!!!
DROP TABLE EMP;

CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE, --기본값설정
  CONSTRAINT EMP_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPT(DEPT_CODE)
);
-----------------------------------------------------------------------
/*
  3) UNIQUE
      : 중복안됨, NULL허용(NOT NULL을 설정하면 PK와 동일) 
      : 후보키중에 대표키가 될수 없는 키를 UNIQUE 설정한다. 
      :  한테이블에 여러개의 컬럼에 설정가능
      
  4) CHECK
      : 조건을 설정하여 조건에 만족하지 않는 정보는 INSERT 할수 없다!
    
  
  5) DEFAULT
      : 기본값 설정(자주사용되는 값을 미리 설정해놓고 자동으로 값이 들어갈수 있또록 하는것)
      : EX) 등록일, 조회수....
      : DEFAULT를 설정할때는 CONSTRAINT 별칭은 안쓴다!!!
      : NOT NULL을 설정하면 DEFALUT를 함께 사용할때는 반드시 DEFAULT를 먼저 작성한다.
*/

--테이블 생성
CREATE TABLE TEST(
  ID VARCHAR2(10)  PRIMARY KEY,
  JUMIN CHAR(13) NOT NULL UNIQUE,
  NAME VARCHAR2(10) UNIQUE, --중복X, NULL허용
  AGE NUMBER(2) CHECK(AGE >=20 AND AGE <= 30),
  GENDER CHAR(3) CHECK(GENDER='남' OR GENDER='여'),
  LOC VARCHAR2(10) DEFAULT '서울',
  REG_DATE DATE  DEFAULT SYSDATE NOT NULL -- 순서중요
);

DROP TABLE TEST;

SELECT * FROM TEST;
DESC TEST;
SELECT * FROM TEST;
--레코드 삽입
INSERT INTO TEST VALUES('JANG','111','희정',22,'남',DEFAULT, DEFAULT);

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('HEE','222','나영',22,'남');

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('KIM',NULL,'희선',22,'여');--JUMIN에 NULL허용 X
INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('KIM','222','희선',22,'여');--JUMIN에 중복 허용 X


INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('AA','333',NULL,22,'여'); --NAME에 NULL허용 O
INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('BB','444',NULL,22,'여');  --NAME에 또 NULL허용 O

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('CC','55','정희',31,'남'); -- 나이체크 X

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('DD','555','효민',26,'M');  --성별체크 X

---------------------------------------------------------------------------------------------------
/*
  테이블 수정
  
 ① 컬럼추가
  alter table 테이블이름 add 
     (컬럼명 자료형 [제약조건] , 컬럼명 자료형 [제약조건] , ....)
 
 ② 컬럼삭제
 alter table 테이블이름 drop column 컬럼이름
 
 ③ datatype변경
    alter table 테이블이름 modify 컬럼이름 변경자료형
    
④ 컬럼이름 변경
 alter table 테이블이름 rename column 기존컬럼명 to 변경컬럼명
 
 ⑤ 제약조건 추가
  alter table 테이블이름 ADD CONSTRAINT 별칭 제약조건종류 ;
  
 -제약조건 삭제
  ALTER TABLE 테이블이름 DROP CONSTRAINT 별칭;
  
 
 - 테이블 삭제
 drop table 테이블이름

*/
SELECT * FROM TEST;
ALTER TABLE  TEST ADD (PHONE VARCHAR2(10) , ETC VARCHAR2(20) DEFAULT '기타' NOT NULL );

alter table TEST ADD CONSTRAINT PHONE_CK CHECK(PHONE='1111' OR PHONE='2222');
 
ALTER TABLE TEST DROP CONSTRAINT PHONE_CK;
 
ALTER TABLE TEST ADD CONSTRAINT ETC_CK CHECK(ETC = '기타' OR ETC = 'X');
 
ALTER TABLE TEST DROP CONSTRAINT ETC_CK;
 
ALTER TABLE TEST DROP COLUMN PHONE;

ALTER TABLE  TEST ADD PHONE VARCHAR2(10);
---------------------------------------------------------------------------
/*
SQL의 종류
 - DDL문장(CREATE, DROP, ALTER, TRUNCATE)
 - DML문장(INSERT ,UPDATE, DELETE)
*/

/*
  데이터 조작 : DML(INSERT , UPDATE, DELETE)
   - ROLLBACK OR COMMIT 가능
   
   1) INSERT문장
       -INSERT INTO 테이블이름(컬럼명, 컬럼명,....) VALUES(값, 값,값,....);
       -INSERT INTO 테이블이름 VALUES(값, 값,값,....); -- 모든 컬럼에 순서대로 값을 넣을때!!!
   
   2) DELETE문장
       DELETE [FROM] 테이블이름
       [WHERE 조건식]
   
   3) UPDATE문장
      UPDATE 테이블이름
      SET 컬럼명=변경값 , 컬럼명=변경값,....
      [WHERE 조건식] 

*/
--샘플테이블 필요하다. 
/*
   --테이블 복사
   CREATE TABLE 테이블이름
   AS 복사할테이블정보;
   
   
    주의 : 테이블을 복사하면 제약조건은 복사 안된다!!! - 복사한후에 제약조건을 ALTER를 이용해서 추가한다.

*/

--SCOTT계정의 접속한다.   CONN SCOTT/TIGER
SELECT * FROM EMP;

--1)모든컬럼, 모든레코드 복사하기
CREATE TABLE COPY_EMP
AS SELECT *FROM EMP;

SELECT * FROM COPY_EMP;

--2)원하는 컬럼, 원하는 레코드만 복사하기
CREATE TABLE COPY_EMP2
AS SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE DEPTNO=20;

SELECT * FROM COPY_EMP2;


--3)테이블의 구조만 복사하기 
CREATE TABLE COPY_EMP3
AS SELECT * FROM EMP WHERE 1=0;

SELECT * FROM COPY_EMP3;
DESC COPY_EMP3;


--COPY_EMP 테이블의 내용을 수정, 삭제
SELECT * FROM COPY_EMP;

--EX) EMPNO가 7782인 사원의 SAL을 5000, HIREDATE는 현재날짜로 변경한다.
 UPDATE COPY_EMP
 SET SAL=5000 , HIREDATE=SYSDATE
 WHERE EMPNO=7782;
 
  UPDATE COPY_EMP
 SET SAL=5000 , HIREDATE=SYSDATE
 WHERE EMPNO=9000;
 
 COMMIT;
 
 ROLLBACK;

--EX) SAL가 2000 ~ 3000인 사원의 COMM을 100으로, JOB을 PROGRMER로 변경한다.
UPDATE COPY_EMP
SET COMM=100, JOB='PROGRAMER'
WHERE SAL >=2000 AND SAL <=3000;

SELECT * FROM COPY_EMP ORDER BY SAL;

--EX) DEPTNO가 20 이거나 30인 사원을 삭제한다. 
DELETE COPY_EMP
WHERE DEPTNO=20 OR DEPTNO=30;

DESC COPY_EMP











