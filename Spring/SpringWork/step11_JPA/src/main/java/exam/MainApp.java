package exam;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MainApp {
	
	public static void main(String[] args) {
		System.out.println("JPA 시작하기 ------------------");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin(); // transaction 시작
		
		// 등록 
//		em.persist(Customer.builder().age(20).userName("희정").birthDay(new Date()).build());
//		em.persist(Customer.builder().age(25).userName("채원").birthDay(new Date()).build());
//		em.persist(Customer.builder().age(26).userName("원영").birthDay(new Date()).build());

		// 조회
//		Customer cu = em.find(Customer.class, 3L);
//		System.out.println(cu);
		
		// 수정
//		cu.setUserName("얼짱");
//		cu.setAge(50);
		
		// 삭제
//		em.remove(cu);
		
		///////////////////////////////////////////////////
		// JPQL 문법 : 객체 중심으로 쿼리를 작성하는 것.
		// 이름이 "희정"인 레코드 검색
//		String sql = "select c from Customer c where c.age >= 25";
//		List<Customer> list = em.createQuery(sql, Customer.class).getResultList();
//		System.out.println(list);
		
		String sql = "select c from Customer c where c.userName like ?1 or c.age > ?2";
		
		
		List<Customer> list = em
		.createQuery(sql, Customer.class)
		.setParameter(1, "%원%")
		.setParameter(2, 20)
		.getResultList();
		
		System.out.println(list);
		
		et.commit(); // transaction end
		
		
		
	}

}
