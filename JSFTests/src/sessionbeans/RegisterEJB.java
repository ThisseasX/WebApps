package sessionbeans;

import entities.Role;
import entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SuppressWarnings("unused")
@Stateless
public class RegisterEJB {

    @PersistenceContext(unitName = "JSFPU")
    private EntityManager em;

    public void register(User u) {
        em.persist(u);
    }

    public List<Role> fetchAllRoles() {
        return em
                .createNamedQuery(Role.GET_ALL, Role.class)
                .getResultList();
    }
}
