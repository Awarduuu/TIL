package exam;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AssociationMainApp {
	
	public static void main(String[] args) {
		System.out.println("JPA 시작하기 (연관관계 TEST)------------------");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
//		Team t1 = new Team(null, "team01");
//		Team t2 = new Team(null, "team02");
//		Team t3 = new Team(null, "team03");
//		
//		em.persist(t1);
//		em.persist(t2);
//		em.persist(t3);
//		
//		em.persist(Member.builder().name("희정").age(20).team(t1).build());
//		em.persist(Member.builder().name("채원").age(22).team(t1).build());
//		em.persist(Member.builder().name("나영").age(25).team(t1).build());
//		em.persist(Member.builder().name("삼순").age(28).team(t2).build());
//		em.persist(Member.builder().name("갑돌").age(21).team(t3).build());
		
		
		//회원 검색!
//		Member m = em.find(Member.class, 1L);
//		
//		System.out.println(m);
//		System.out.println("---------------------------");
//		
//		Team team = m.getTeam();
//		System.out.println(team);
		
		//팀에 소속된 회원 검색
		Team t = em.find(Team.class, 7L);
		
		List<Member> list = t.getMemberList();
		
		System.out.println(list);
		et.commit();
		
		
		
	}

}
