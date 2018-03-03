package services;

import entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RestService {

//    @PersistenceContext
//    private EntityManager em;

    public List<UserEntity> getAll() {
        EntityManager em = Persistence.createEntityManagerFactory("DBTest").createEntityManager();
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u", UserEntity.class);
        return query.getResultList();
    }
}
