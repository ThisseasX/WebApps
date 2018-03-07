package services;

import entities.UserEntity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class RestService {

//    Injection not working
//    @PersistenceContext
//    private EntityManager em;

    public List<UserEntity> getAll() {
        EntityManager em = Persistence.createEntityManagerFactory("DBTest").createEntityManager();
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u", UserEntity.class);
        return query.getResultList();
    }

    public UserEntity getFromId(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("DBTest").createEntityManager();
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u where id = :id", UserEntity.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
