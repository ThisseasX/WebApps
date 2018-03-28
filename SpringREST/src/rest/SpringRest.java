package rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRest {

    @GetMapping("/test")
    public String getAll() {
        return "hello";
    }
}
