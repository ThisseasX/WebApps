package services;

import entities.CandidatesEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CandidateServices {

    public static void insertCandidate(int c_afm, String c_name, String c_surname) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        CandidatesEntity c = new CandidatesEntity();
        c.setcAfm(c_afm);
        c.setcName(c_name);
        c.setcSurname(c_surname);

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }
}
