package sample02;

public class MemberDAO {
	public MemberDAO() {
		System.out.println("MemberDAO()");
	}
	
	public void insert(Member member) {
		System.out.println("MemberDAO의 insert");
		System.out.println("Member = " + member);
	}
}
