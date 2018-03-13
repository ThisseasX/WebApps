package controllers;

import models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import validators.UserValidator;

import javax.validation.Valid;

@Controller
public class FormController {

    @InitBinder
    public void bind(WebDataBinder binder) {
        binder.addValidators(new UserValidator());
    }

    @GetMapping("/form")
    public String form(@ModelAttribute("user") User user) {
        return "form";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "success";
    }
}
