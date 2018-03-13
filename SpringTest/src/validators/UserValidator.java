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
                "username.empty",
                "Username must not be empty!");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "password",
                "password.empty",
                "Password must not be empty!");

        User u = (User) o;

        if (u.getUsername().length() <= 3 && !u.getUsername().isEmpty()) {
            errors.rejectValue("username",
                    "username.short",
                    "Username must be longer than 3 characters!");
        }

        if (u.getPassword().length() <= 3 && !u.getPassword().isEmpty()) {
            errors.rejectValue("password",
                    "password.short",
                    "Password must be longer than 3 characters!");
        }

        if (u.getUsername().equals(u.getPassword()) &&
                !(u.getPassword().isEmpty() || u.getPassword().isEmpty())) {
            errors.rejectValue("password",
                    "details.same",
                    "Your Username and Password must differ!");
        }

        if (u.getPassword().equals("123")) {
            errors.rejectValue("password",
                    "password.weak",
                    "Your Password is too weak!");
        }
    }
}
