package rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRest {

    @GetMapping("/test")
    public ResponseEntity getAll() {
        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }
}
