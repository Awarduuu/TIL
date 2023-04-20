1-1. create 문을 만들어 실행한다.

CREATE TABLE users
( 
    user_seq   NUMBER,
    name  VARCHAR2(50),
    email      VARCHAR2(50),
    phone      VARCHAR2(15),
    is_sleep    CHAR(1)
);


1-2. user_seq 컬럼에 PK Constraint 를 적용한다.

alter table users add constraint users_pk primary key (user_seq);


1-3. email  컬럼에 not null, unique 속성을 부여한다.

alter table users add unique(email);
alter table users modify email not null;


1-4. is_sleep  컬럼에 default 값으로 ‘N’을 설정한다.

alter table users modify  (is_sleep  default 'N');

--  기존 users 데이터 truncate
truncate table users;
--	password varchar2(20) not null 추가
alter table users add password varchar2(20) not null;
--	login test user 1건 등록 
insert into users values( , '홍길동', 'hong@gildong.com', '010-1111-1111', 'N', '1234');
commit;

create sequence user_seq;

drop sequence user_seq;

select * from users;