package pl.atos.finalworkshop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.atos.finalworkshop.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    UserService userService;


    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        if (userService == null) {
            return true;
        }

        if (userService.findByEmail(email) != null) {
            return false;
        }
        return true;
    }
}
