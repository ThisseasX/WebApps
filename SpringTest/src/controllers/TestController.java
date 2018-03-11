package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test_controller")
public class TestController {

    @GetMapping("/test")
    public String testMethod(ModelMap m) {
        m.addAttribute("test_message", "Hello this is a test message!");
        return "test_page";
    }

    @GetMapping("/test/{name}/{surname}")
    public String search(ModelMap m, @PathVariable String name, @PathVariable String surname) {
        String s = String.format("My name is %s and my surname is %s", name, surname);
        m.addAttribute("test_message", s);
        return "test_page";
    }
}
