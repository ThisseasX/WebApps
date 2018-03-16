package services;

import entities.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserService {

    @PersistenceContext
    private EntityManager em;

    public List<UserEntity> getAll() {
        return em
                .createNamedQuery(UserEntity.GET_ALL, UserEntity.class)
                .getResultList();
    }

    public UserEntity getById(int id) {
        UserEntity user = null;
        try {
            user = em
                    .createNamedQuery(UserEntity.GET_BY_ID, UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Transactional
    public void insert(UserEntity u) {
        em.persist(u);
        em.flush();
    }
}
