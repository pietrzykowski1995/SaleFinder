package pl.atos.finalworkshop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.atos.finalworkshop.user.UserService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

    @Autowired
    UserService userService;

    @Override
    public boolean isValid(String userName, ConstraintValidatorContext constraintValidatorContext) {

        if (userService == null) {
            return true;
        }

        if (userService.findByUserName(userName) != null) {
            return false;
        }
        return true;
    }
}
