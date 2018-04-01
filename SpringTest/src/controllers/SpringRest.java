package controllers;

import entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;

import java.util.List;

@RestController
public class SpringRest {

    private final UserService service;

    @Autowired
    public SpringRest(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAll() {
        List<UserEntity> list = service.getAll();
        if (list == null) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public boolean insert(@RequestBody UserEntity u) {
        System.out.println("Inserting: " + u.getName());
        return true;
    }
}
