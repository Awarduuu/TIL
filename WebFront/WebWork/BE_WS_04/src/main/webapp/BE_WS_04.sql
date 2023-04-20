1-1. create ���� ����� �����Ѵ�.

CREATE TABLE users
( 
    user_seq   NUMBER,
    name  VARCHAR2(50),
    email      VARCHAR2(50),
    phone      VARCHAR2(15),
    is_sleep    CHAR(1)
);


1-2. user_seq �÷��� PK Constraint �� �����Ѵ�.

alter table users add constraint users_pk primary key (user_seq);


1-3. email  �÷��� not null, unique �Ӽ��� �ο��Ѵ�.

alter table users add unique(email);
alter table users modify email not null;


1-4. is_sleep  �÷��� default ������ ��N���� �����Ѵ�.

alter table users modify  (is_sleep  default 'N');

--  ���� users ������ truncate
truncate table users;
--	password varchar2(20) not null �߰�
alter table users add password varchar2(20) not null;
--	login test user 1�� ��� 
insert into users values( , 'ȫ�浿', 'hong@gildong.com', '010-1111-1111', 'N', '1234');
commit;

create sequence user_seq;

drop sequence user_seq;

select * from users;