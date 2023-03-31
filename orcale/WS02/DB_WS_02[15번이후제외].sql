
1. ����ȣ ( user_seq ) �� 111 �� ���� ( account ) ���̺��� ��ȸ�Ѵ�.

select * from account where user_seq = 111;


2. �ܰ� ( balance ) �� 5000 �̸��� ���� ( account ) ���̺��� ��ȸ�Ѵ�.

select * from account where balance < 5000;


3. �ܰ� ( balance ) �� 5000 �̻� 10000 ������ ���� ( account ) ���̺��� ��ȸ�Ѵ�.

select * from account where balance between 5000 and 10000;


4. ���¹�ȣ ( accountNumber ) �� ��4�� �� �����ϴ� ���� ( account ) ���̺��� ��ȸ�Ѵ�. 

select * from account where account_number like '%4%';


5. ���� ( name ) �� ��� �� �����ϴ� �� ( users ) ���̺��� ��ȸ�Ѵ�.

select * from users where name like '��%';


6. ���� ( account ) ���̺� �ִ� �� ��ȣ ( user_seq ) �� �ߺ����� ��ȸ�Ѵ�.

select distinct( user_seq ) from account;


7. �ܰ� ( balance ) �� ���� ( null ) ���� ( account ) ���̺��� ��ȸ�Ѵ�.

select * from account where balance is null;


8. ����ȣ ( user_seq ) �� �ִ� ���� ( account ) ���̺��� ��ȸ�Ѵ�.

select * from account where user_seq is not null;


9. ����ȣ ( user_seq ) �� �ְ�, �ܰ� 4000 ������ ���� ( account ) ���̺��� ��ȸ�Ѵ�.

select * from account 
 where user_seq is not null
   and balance <= 4000;


10. ���� ( account ) ���̺��� ����ȣ ( user_seq ) �������� ������������ �����Ͽ� ��ȸ�Ѵ�.
   
select * from account order by user_seq asc; 


11. ���� ( account ) ���̺��� ����ȣ ( user_seq ) �������� ������������, 
�׸��� �� �ȿ��� �ܰ�( balance ) �������� ������������ �����Ͽ� ��ȸ�Ѵ�.
   
select * from account order by user_seq asc, balance desc; 


12. ���� ( account ) ���̺��� ��ȸ�ϵ�, balance ���� ������ 0 ���� ǥ���Ѵ�.

select account_seq, account_number, nvl(balance, 0), user_seq from account;


13. �� ( users ) ���̺��� ��ȸ�ϵ�, email�� @���� �� �κ��� ���� �� ���̵� ǥ���Ѵ�. �÷��� email ��� email_id �� �����Ѵ�.

select user_seq, substr( email, 0, instr(email, '@')-1 ) email_id, phone, is_sleep from users;


14. �� ( users ) ���̺��� ��ȸ�ϵ�, phone �� ��-�� �� �����ϰ� ǥ���Ѵ�. �÷��� phone_short �� �����Ѵ�.

select user_seq, email, replace(phone,'-','') phone_short, is_sleep from users;

