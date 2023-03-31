-- ������ �������� �����Ѵ�. conn ������/���

/*
  Datatype�� ����
  1) ���ڿ�   
      CHAR(BYTE��) : �������� - �ִ� 2000 BYTE
      VARCHAR2(BYTE��) : �������� -�ִ� 4000 BYTE
      
      *�����ڵ带 ����!!
      NCHAR(BYTE��)
      NVARCHAR2(BYTE��)
      
      * �ݵ�� ���ڴ� '��'  �������� ����Ѵ�.
      * ORACLE���� ���� UTF-8 ���ڵ����� �ѱ��ڴ� 3BYTE�̴�!!
      
        EX) CHAR(6) : �ѱ� 2��, ������ 6����
            VARCHAR2(6) : �ѱ� 2��, ������ 6����
            
      * CHAR(6 CHAR) : BYTE�� ������� 6���ڱ���
        VARCHAR2(6 CHAR) : BYTE�� ������� 6���ڱ���
        
      * ��뷮�� �������� �����ؾ��ϴ°�� 
       LOB : LARGE OBJECT ���ڷ� ��뷮�� �����͸� �����Ҽ� �ִ� ������ Ÿ�� 
         1) CLOB : �������� ���� �� ���ڿ��� �����Ҷ� 4GB
         2) BLOB :  �������� 2���� ���¸� �����Ҷ� 4GB
        - LOBŸ���� ���������� �ʴ´�
        
    
  2) ����
     : NUMBER
       SMALLINT
       INT
       
       * SMALLINT �Ǵ� INT�� �����ص� �ᱹ ����������  NUMBER Ÿ������ �ȴ�. 
         - ������, �Ǽ��� ǥ��
         EX) NUMBER(1) : ���� -9 ~ 9 ǥ��
             NUMBER(2) : -99 ~ 99 
             
             NUMBER(5,3) : ��ü 5�ڸ����� 3�ڸ��� �Ҽ����ڸ�.
  
  
  3) ��¥
     : DATE : ����� �ú��� ����
       TIMESTAMP : ����� �ú��� + MILS �������� �� �����ϰ� ǥ��!!!
      
      *��¥�� �ݵ�� '��-��-��' �������� ��� ����Ѵ�.
      * ���� ��¥�ͽð��� ���ϴ� �Լ� SYSDATE ����Ѵ�.
        EX) SELECT SYSDATE FROM DUAL;
*/


/*
  -���̺� ����
  create table ���̺��̸�(
    �÷��� datatype [default �⺻��] [ null | not null ] [ constraint ��Ī �������� ] ,
    �÷��� datatype [default �⺻��] [ null | not null ] [ constraint ��Ī �������� ] ,
    .....
)

  - ���������� ����
   1) PRIMARY KEY : ��ǥŰ, �ߺ�X, NOT NULL
   2) FOREIGN KEY :�ٸ� ���̺��� �÷��� ����
   3) UNIQUE : PK����(���̺��� ��ǥŰ�� �ɼ� ���� �׷����� �����ؾ��ϴ� �Ӽ��� ����) 
   4) CHECK : DOMAIN�� ���� �ִ� ���� ������ üũ
   
   5) DEFAULT  : �⺻�� ����

*/
/*
   1) PRIMARY KEY - PK, �⺻Ű, ��ǥŰ
      : PK�� �����ϸ� �ߺ��ȵ�, NOT NULL , �ڵ��Ƿ� INDEX���� - EX) �й�, ����, �ֹι�ȣ, ��ǰ�ڵ�,...���̵�...
      : PK�� �ϳ��� ���̺� �ݵ�� �Ѱ��� ����
      : 2���� �̻��� �÷��� �ϳ��� ��� PK���� ���� 
          - ����Ű���� : ����Ҷ� �����ؼ� �𵨸� �����ӿ��� ����Ű�� �븮Ű�� ��ȯ�ϴ� ��� ����!!!
*/

--EX) ���̺� ����
CREATE TABLE MEMBER(
  ID VARCHAR2(20) CONSTRAINT MEMBER_ID_PK PRIMARY KEY ,
  NAME VARCHAR2(10) NOT NULL,
  JUMIN CHAR(13) ,
  AGE NUMBER(2) , -- -99 ~ 99
  ADDR VARCHAR2(10 CHAR) ,
  REG_DATE DATE
);

--���̺� �˻�
SELECT * FROM MEMBER;

--���̺� ����
DESC MEMBER;


/*
  ���ڵ� ���
  INSERT INTO ���̺��̸�(�÷���, �÷���,....) VALUES(��, ��,��,....);
  INSERT INTO ���̺��̸� VALUES(��, ��,��,....); -- ��� �÷��� ������� ���� ������!!!
*/

INSERT INTO MEMBER VALUES('JANG','������','1111',20,'����','2022-1-20');
INSERT INTO MEMBER(ID,NAME) VALUES('HEE','����');

--�ߺ�
INSERT INTO MEMBER(ID,NAME) VALUES('HEE','ȿ��');--X

INSERT INTO MEMBER(ID,NAME) VALUES('hee','ȿ��'); --�����ʹ� ��ҹ��� �ٸ���.  

INSERT INTO MEMBER(NAME) VALUES('ȿ��'); --X

INSERT INTO MEMBER(ID,NAME) VALUES('AA','�ҳ�ô�'); --X
INSERT INTO MEMBER(ID,NAME,ADDR) VALUES('BB','����','����� ������ ����'); --O

INSERT INTO MEMBER(ID,NAME,ADDR) VALUES('CC','����','����� ������ ����22'); --X

INSERT INTO MEMBER(ID,NAME, AGE) VALUES('DD','����',100);  --X
INSERT INTO MEMBER(ID,NAME, AGE) VALUES('DD','����',99);
INSERT INTO MEMBER(ID,NAME, AGE) VALUES('FF','����',-99);

INSERT INTO MEMBER(ID,NAME, REG_DATE) VALUES('EE','ȿ��',SYSDATE);

--���ڵ� �˻�
SELECT * FROM MEMBER;


--char vs varchar2 ��
INSERT INTO MEMBER(ID, NAME, JUMIN) VALUES('GG','A','B');

INSERT INTO MEMBER(ID, NAME, JUMIN) VALUES('TT','A ','B ');


--VARCHAR2 �� 
SELECT * FROM MEMBER WHERE NAME ='A ';

-- CHAR ��
SELECT * FROM MEMBER WHERE JUMIN ='B ';
---------------------------------------------------------
/*
  ���̺� ����
  DROP TABLE ���̺��̸�;
*/
DROP TABLE MEMBER;

/*
  �ΰ��� �÷��� �ϳ��� ��� PK���� - ����Ű
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
--���ڵ� ����
INSERT INTO MEMBER VALUES('JANG','����','11111',15, NULL ,SYSDATE);

INSERT INTO MEMBER(ID,JUMIN , NAME) VALUES('JANG','22222','����');

INSERT INTO MEMBER(ID,JUMIN , NAME) VALUES('HEE','22222','����');

INSERT INTO MEMBER(ID,JUMIN , NAME) VALUES('JANG','22222','����'); --X
----------------------------------------------------------------------------
/*
  2) FOREIGN KEY - FK = �ܷ�Ű
      : �ٸ� ���̺��� PK�� �����ϴ� ��.
      : ���̺� ���ڵ带 �߰��Ҷ� �����Ǵ� ����� ���̿ܿ��� ��� �Ҽ� ����.
          - �������Ἲ��Ģ!!!
      : NULL���, �ߺ�����!!
      : �ϳ��� ���̺� �������� �÷��� FK���������ϴ�.
      
      : ��������� ���� - �ڱ��ڽ����̺��� PK�� �����ϴ°�!!!
      
      *���ǻ���
        INSERT �Ҷ� : �θ�Ű�� INSERT -> �ڽ� INSERT 
        DELETE�Ҷ� :  �����ϰ� �ִ� �ڽ� DELETE -> �θ� DELETE �ؾ��Ѵ�.
      
             * �̷��� ���ǻ��׿� ���� �������� �ذ��ϱ� ���ؼ�.
               FK�� �����Ҷ� ON DELETE CASCADE �� �߰��ϸ� �θ��ڵ带 �����ϸ�
              �� �θ�Ű�� �����ϴ� ��� ���̺��� ���ڵ带 �Բ� �����Ѵ�.
	      �Ǵ� FK�����Ҷ� on delete set null �� �߰��ϸ�
	      �θ��ڵ� �����ɶ� �����Ǵ� �ڽķ��ڵ��� ���� null�̵ȴ�.
      
     
*/
SELECT * FROM EMP


--EX) �μ����̺��� ����
CREATE TABLE DEPT(
  DEPT_CODE CHAR(3) CONSTRAINT DEPT_CODE_PK  PRIMARY KEY,
  DNAME VARCHAR2(30) NOT NULL,
  LOC VARCHAR2(50)
);

--���ڵ� ����
INSERT INTO DEPT VALUES('A01','�渮��','����');
INSERT INTO DEPT VALUES('A02','������','�뱸');
INSERT INTO DEPT VALUES('A03','�����','����');

--EX) ������̺� ����
CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --�⺻������
);


SELECT * FROM DEPT;
SELECT * FROM EMP;

INSERT INTO EMP(EMP_NO, ENAME, SAL, DEPT_CODE)VALUES(100,'������',3000,'A01');

INSERT INTO EMP VALUES(200,'��ȿ��',1500,'A01',NULL);

INSERT INTO EMP VALUES(300,'�̹̼�',200,NULL , DEFAULT);

INSERT INTO EMP VALUES(400,'�����',2000, 'A04' , DEFAULT); --X ����

--DEPT���̺��� �������� �ʴ� �μ��ڵ带 �����غ���.
DELETE FROM DEPT WHERE DEPT_CODE='A03'; --����

DELETE FROM DEPT WHERE DEPT_CODE='A01'; -- x(���� �ڽķ��ڵ� ������, �θ��ڵ� ��������)

DELETE FROM EMP WHERE DEPT_CODE='A01'; --�ڽ� ����
DELETE FROM DEPT WHERE DEPT_CODE='A01'; --�θ� ���� 


DROP TABLE EMP;
DROP TABLE DEPT;
--ON DELETE CASCADE VS  on delete set null

-- ON DELETE CASCADE  TEST
CREATE TABLE DEPT(
  DEPT_CODE CHAR(3) CONSTRAINT DEPT_CODE_PK  PRIMARY KEY,
  DNAME VARCHAR2(30) NOT NULL,
  LOC VARCHAR2(50)
);

--���ڵ� ����
INSERT INTO DEPT VALUES('A01','�渮��','����');
INSERT INTO DEPT VALUES('A02','������','�뱸');
INSERT INTO DEPT VALUES('A03','�����','����');

--EX) ������̺� ����
CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE CASCADE ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --�⺻������
);

INSERT INTO EMP VALUES(200,'��ȿ��',1500,'A01',NULL);
INSERT INTO EMP VALUES(300,'������',1500,'A01',NULL);
INSERT INTO EMP VALUES(400,'������',1500,'A02',NULL);

SELECT * FROM DEPT;
SELECT * FROM EMP;

--�����ǰ� �ִ� �θ�Ű ���ڵ带 �����غ���.
DELETE FROM DEPT WHERE DEPT_CODE='A01';


DROP TABLE EMP;
--on delete set null TEST
CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) on delete set null ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --�⺻������
);

INSERT INTO EMP VALUES(200,'��ȿ��',1500,'A02',NULL);
INSERT INTO EMP VALUES(300,'������',1500,'A02',NULL);
INSERT INTO EMP VALUES(400,'������',1500,'A03',NULL);

DELETE FROM DEPT WHERE DEPT_CODE='A02';

--����!!!!!
/*
   ���ڵ� �������
    1) ROLLBACK ó������ - DML
      DELETE [FROM] ���̺��̸�
      [WHERE ���ǽ�]
      
        * FROM ��������, WHERE���� ������ ��� ���ڵ尡 �����ȴ�.
          
    2) ROLLBACK �ȵȴ�. - DDL
     TRUNCATE TABLE ���̺��̸�; --��緹�ڵ带 ����
      
*/
--���� ��Ȳ�� ��� ����Ϸ�
COMMIT;

SELECT * FROM EMP;
DELETE FROM EMP; --��緹�ڵ� ����

ROLLBACK;

TRUNCATE TABLE EMP;

-- DEPT���� �����θ� �����غ���.
DELETE DEPT WHERE DEPT_CODE='A02'; --O
SELECT * FROM DEPT;

--DEPT���� �����θ� �����غ���.
DELETE DEPT WHERE DEPT_CODE='A01'; --X

--�����ǰ� �ִ� �ڽķ��ڵ带 �����ϰ� �θ��ڵ带 �����Ѵ�.
DELETE EMP WHERE DEPT_CODE='A01';
DELETE DEPT WHERE DEPT_CODE='A01';


ROLLBACK
-- �� ������ �����ؼ� FK�� �����Ҷ� ON DELETE CASCADE �ɼ��� �ش�.
SELECT * FROM DEPT;
SELECT * FROM EMP;

DROP TABLE EMP;

CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) CONSTRAINT EMP_CODE_FK REFERENCES DEPT(DEPT_CODE) ON DELETE CASCADE,  -- FK
  HIREDATE DATE DEFAULT SYSDATE --�⺻������
);

SELECT * FROM EMP;
SELECT * FROM DEPT;

DELETE DEPT WHERE DEPT_CODE='A01';

--�ܷ�Ű�� �����Ҷ� �ǵڿ� �ۼ��ϱ�!!!!
DROP TABLE EMP;

CREATE TABLE  EMP(
  EMP_NO NUMBER(3) CONSTRAINT EMP_NO_PK PRIMARY KEY,
  ENAME VARCHAR2(10) NOT NULL,
  SAL NUMBER(5),
  DEPT_CODE CHAR(3) ,  -- FK
  HIREDATE DATE DEFAULT SYSDATE, --�⺻������
  CONSTRAINT EMP_FK FOREIGN KEY(DEPT_CODE) REFERENCES DEPT(DEPT_CODE)
);
-----------------------------------------------------------------------
/*
  3) UNIQUE
      : �ߺ��ȵ�, NULL���(NOT NULL�� �����ϸ� PK�� ����) 
      : �ĺ�Ű�߿� ��ǥŰ�� �ɼ� ���� Ű�� UNIQUE �����Ѵ�. 
      :  �����̺� �������� �÷��� ��������
      
  4) CHECK
      : ������ �����Ͽ� ���ǿ� �������� �ʴ� ������ INSERT �Ҽ� ����!
    
  
  5) DEFAULT
      : �⺻�� ����(���ֻ��Ǵ� ���� �̸� �����س��� �ڵ����� ���� ���� �ֶǷ� �ϴ°�)
      : EX) �����, ��ȸ��....
      : DEFAULT�� �����Ҷ��� CONSTRAINT ��Ī�� �Ⱦ���!!!
      : NOT NULL�� �����ϸ� DEFALUT�� �Բ� ����Ҷ��� �ݵ�� DEFAULT�� ���� �ۼ��Ѵ�.
*/

--���̺� ����
CREATE TABLE TEST(
  ID VARCHAR2(10)  PRIMARY KEY,
  JUMIN CHAR(13) NOT NULL UNIQUE,
  NAME VARCHAR2(10) UNIQUE, --�ߺ�X, NULL���
  AGE NUMBER(2) CHECK(AGE >=20 AND AGE <= 30),
  GENDER CHAR(3) CHECK(GENDER='��' OR GENDER='��'),
  LOC VARCHAR2(10) DEFAULT '����',
  REG_DATE DATE  DEFAULT SYSDATE NOT NULL -- �����߿�
);

DROP TABLE TEST;

SELECT * FROM TEST;
DESC TEST;
SELECT * FROM TEST;
--���ڵ� ����
INSERT INTO TEST VALUES('JANG','111','����',22,'��',DEFAULT, DEFAULT);

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('HEE','222','����',22,'��');

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('KIM',NULL,'��',22,'��');--JUMIN�� NULL��� X
INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('KIM','222','��',22,'��');--JUMIN�� �ߺ� ��� X


INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('AA','333',NULL,22,'��'); --NAME�� NULL��� O
INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('BB','444',NULL,22,'��');  --NAME�� �� NULL��� O

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('CC','55','����',31,'��'); -- ����üũ X

INSERT INTO TEST(ID,JUMIN,NAME,AGE,GENDER) VALUES('DD','555','ȿ��',26,'M');  --����üũ X

---------------------------------------------------------------------------------------------------
/*
  ���̺� ����
  
 �� �÷��߰�
  alter table ���̺��̸� add 
     (�÷��� �ڷ��� [��������] , �÷��� �ڷ��� [��������] , ....)
 
 �� �÷�����
 alter table ���̺��̸� drop column �÷��̸�
 
 �� datatype����
    alter table ���̺��̸� modify �÷��̸� �����ڷ���
    
�� �÷��̸� ����
 alter table ���̺��̸� rename column �����÷��� to �����÷���
 
 �� �������� �߰�
  alter table ���̺��̸� ADD CONSTRAINT ��Ī ������������ ;
  
 -�������� ����
  ALTER TABLE ���̺��̸� DROP CONSTRAINT ��Ī;
  
 
 - ���̺� ����
 drop table ���̺��̸�

*/
SELECT * FROM TEST;
ALTER TABLE  TEST ADD (PHONE VARCHAR2(10) , ETC VARCHAR2(20) DEFAULT '��Ÿ' NOT NULL );

alter table TEST ADD CONSTRAINT PHONE_CK CHECK(PHONE='1111' OR PHONE='2222');
 
ALTER TABLE TEST DROP CONSTRAINT PHONE_CK;
 
ALTER TABLE TEST ADD CONSTRAINT ETC_CK CHECK(ETC = '��Ÿ' OR ETC = 'X');
 
ALTER TABLE TEST DROP CONSTRAINT ETC_CK;
 
ALTER TABLE TEST DROP COLUMN PHONE;

ALTER TABLE  TEST ADD PHONE VARCHAR2(10);
---------------------------------------------------------------------------
/*
SQL�� ����
 - DDL����(CREATE, DROP, ALTER, TRUNCATE)
 - DML����(INSERT ,UPDATE, DELETE)
*/

/*
  ������ ���� : DML(INSERT , UPDATE, DELETE)
   - ROLLBACK OR COMMIT ����
   
   1) INSERT����
       -INSERT INTO ���̺��̸�(�÷���, �÷���,....) VALUES(��, ��,��,....);
       -INSERT INTO ���̺��̸� VALUES(��, ��,��,....); -- ��� �÷��� ������� ���� ������!!!
   
   2) DELETE����
       DELETE [FROM] ���̺��̸�
       [WHERE ���ǽ�]
   
   3) UPDATE����
      UPDATE ���̺��̸�
      SET �÷���=���氪 , �÷���=���氪,....
      [WHERE ���ǽ�] 

*/
--�������̺� �ʿ��ϴ�. 
/*
   --���̺� ����
   CREATE TABLE ���̺��̸�
   AS ���������̺�����;
   
   
    ���� : ���̺��� �����ϸ� ���������� ���� �ȵȴ�!!! - �������Ŀ� ���������� ALTER�� �̿��ؼ� �߰��Ѵ�.

*/

--SCOTT������ �����Ѵ�.   CONN SCOTT/TIGER
SELECT * FROM EMP;

--1)����÷�, ��緹�ڵ� �����ϱ�
CREATE TABLE COPY_EMP
AS SELECT *FROM EMP;

SELECT * FROM COPY_EMP;

--2)���ϴ� �÷�, ���ϴ� ���ڵ常 �����ϱ�
CREATE TABLE COPY_EMP2
AS SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE DEPTNO=20;

SELECT * FROM COPY_EMP2;


--3)���̺��� ������ �����ϱ� 
CREATE TABLE COPY_EMP3
AS SELECT * FROM EMP WHERE 1=0;

SELECT * FROM COPY_EMP3;
DESC COPY_EMP3;


--COPY_EMP ���̺��� ������ ����, ����
SELECT * FROM COPY_EMP;

--EX) EMPNO�� 7782�� ����� SAL�� 5000, HIREDATE�� ���糯¥�� �����Ѵ�.
 UPDATE COPY_EMP
 SET SAL=5000 , HIREDATE=SYSDATE
 WHERE EMPNO=7782;
 
  UPDATE COPY_EMP
 SET SAL=5000 , HIREDATE=SYSDATE
 WHERE EMPNO=9000;
 
 COMMIT;
 
 ROLLBACK;

--EX) SAL�� 2000 ~ 3000�� ����� COMM�� 100����, JOB�� PROGRMER�� �����Ѵ�.
UPDATE COPY_EMP
SET COMM=100, JOB='PROGRAMER'
WHERE SAL >=2000 AND SAL <=3000;

SELECT * FROM COPY_EMP ORDER BY SAL;

--EX) DEPTNO�� 20 �̰ų� 30�� ����� �����Ѵ�. 
DELETE COPY_EMP
WHERE DEPTNO=20 OR DEPTNO=30;

DESC COPY_EMP











