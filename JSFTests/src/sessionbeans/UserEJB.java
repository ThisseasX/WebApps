package sessionbeans;

import entities.Role;
import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("unused")
@Stateless
public class UserEJB {

    @PersistenceContext(unitName = "JSFPU")
    private EntityManager em;

    public void register(User u) {
        em.persist(u);
    }

    public List<Role> fetchAllRoles() {
        return em
                .createNamedQuery("Role.getAll", Role.class)
                .getResultList();
    }

    public List<User> fetchAllUsers() {
        return em
                .createNamedQuery("User.getAll", User.class)
                .getResultList();
    }
}
