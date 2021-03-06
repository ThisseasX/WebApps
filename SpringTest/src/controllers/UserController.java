package controllers;

import entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAll(ModelMap m) {
        List<UserEntity> list = service.getAll();
        m.addAttribute("result_list", list);
        return "users";
    }

    @GetMapping("/{id}")
    public String getById(ModelMap m, @PathVariable int id) {
        UserEntity user = service.getById(id);
        m.addAttribute("result", user);
        return "users";
    }

    @GetMapping("/insert/{name}/{surname}")
    public String insert(ModelMap m, @PathVariable String name, @PathVariable String surname) {
        UserEntity u = new UserEntity(name, surname);
        service.insert(u);
        m.addAttribute("result", u);
        return "users";
    }
}
