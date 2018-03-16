package validators;

import models.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    @Override
    public boolean supports(Class type) {
        return User.class.equals(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "username",
                "username.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "password",
                "password.empty");

        User u = (User) o;

        if (u.getUsername().length() <= 3 && !u.getUsername().isEmpty()) {
            errors.rejectValue("username",
                    "username.short");
        }

        if (u.getPassword().length() <= 3 && !u.getPassword().isEmpty()) {
            errors.rejectValue("password",
                    "password.short");
        }

        if (u.getUsername().equals(u.getPassword()) &&
                !(u.getPassword().isEmpty() || u.getPassword().isEmpty())) {
            errors.rejectValue("password",
                    "details.same");
        }

        if (u.getPassword().equals("123")) {
            errors.rejectValue("password",
                    "password.weak");
        }
    }
}
