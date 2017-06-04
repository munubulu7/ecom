package sys.ecom.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by My System on 6/2/2017.
 */
public class EntityManagerBuilder {
    private static EntityManagerBuilder manager = new EntityManagerBuilder();

    public EntityManagerBuilder() {
    }

    public EntityManagerBuilder getInstance(){
        return manager;
    }

    public EntityManager getEntityManager(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inv");
        EntityManager em = entityManagerFactory.createEntityManager();
        return em;
    }
}
