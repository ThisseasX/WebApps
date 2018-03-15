package controllers;

import entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String testMethod(ModelMap m) {
//        EntityManager em = Persistence
//                .createEntityManagerFactory("DBTest")
//                .createEntityManager();
//        List<UserEntity> list = em
//                .createNamedQuery(UserEntity.GET_ALL, UserEntity.class)
//                .getResultList();
        List<UserEntity> list = service.getUsers();
        m.addAttribute("result_list", list);
        return "users";
    }

    @GetMapping("/{id}")
    public String search(ModelMap m, @PathVariable int id) {
        EntityManager em = Persistence
                .createEntityManagerFactory("DBTest")
                .createEntityManager();
        UserEntity user = null;
        try {
            user = em
                    .createNamedQuery(UserEntity.GET_BY_ID, UserEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        m.addAttribute("result", user);
        return "users";
    }
}
