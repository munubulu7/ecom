package sys.ecom.bean;

import javax.persistence.*;
import java.util.List;
import java.util.logging.Logger;

public class Transaction {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("inv");
    EntityManager em = entityManagerFactory.createEntityManager();
    Logger logger = Logger.getGlobal();
    private static final Transaction tran = new Transaction();

    private Transaction() {
    }

    public static Transaction getInstance() {
        return tran;
    }

    public void begin() {
        em.getTransaction().begin();
        logger.info("Transaction begin.");
    }

    public void rollback() {
        em.getTransaction().rollback();
        logger.info("Transaction rollback successfully.");
    }

    public void commit() {
        logger.info("Please wait...");
        em.getTransaction().commit();
        logger.info("Transaction commited successfully.");
    }

    public String getRecordCount(Class<?> t) {
        Query query = em.createQuery("select COUNT(c) from " + t.getSimpleName() + " c");
        return String.valueOf(query.getSingleResult());
    }

    public <T> void insertData(T t) {
        em.persist(t);
        logger.info("1 row of " + t.getClass().getSimpleName() + " : " + t + " inserted");
    }

    public <T> List<T> getAll(Class<T> t) {
        TypedQuery<T> q = em.createQuery("select c from " + t.getSimpleName() + " c", t);
        List<T> res = q.getResultList();
        logger.info(t.getSimpleName() + ": " + res.size() + " row fetched");
        return res;
    }

    public List<?> getDataForDataTable(Class<?> t, int start, int offset) {
        Query query = em.createQuery("select c from " + t.getSimpleName() + " c");
        query.setFirstResult(start);
        query.setMaxResults(offset);
        List<?> res = query.getResultList();
        logger.info(t.getSimpleName() + " " + res.size() + " row of fetched");
        return res;
    }


}
