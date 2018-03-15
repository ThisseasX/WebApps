package services;

import entities.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserService {

    @PersistenceContext
    private EntityManager em;

//    @Transactional
//    public void persist(UserEntity user) {
//        em.persist(user);
//    }

    public List<UserEntity> getUsers() {
        return em
                .createNamedQuery(UserEntity.GET_ALL, UserEntity.class)
                .getResultList();
    }
}
