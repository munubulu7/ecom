package sys.ecom.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestTran {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inv");
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(new TestData("Debashis", "Haldia"));
		
		TypedQuery<TestData> query=em.createQuery("select c from TestData c",TestData.class);
		for(TestData td:query.getResultList()){
			System.out.println(td);
		}
		em.getTransaction().commit();
		System.out.println("Stop...");
	}
}
