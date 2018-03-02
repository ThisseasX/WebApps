package services;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DBServices {

    public static void insertToDatabase(Object o) {
        EntityManager em = Persistence
                .createEntityManagerFactory("VoteApp")
                .createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(o);
        et.commit();
    }
}
