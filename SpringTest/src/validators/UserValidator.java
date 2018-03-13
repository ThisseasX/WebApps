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
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "Username is empty!");
        User u = (User) o;
        if (u.getUsername().length() <= 3) {
            errors.rejectValue("password", "Password must be longer than 3 chars");
        }
    }
}
