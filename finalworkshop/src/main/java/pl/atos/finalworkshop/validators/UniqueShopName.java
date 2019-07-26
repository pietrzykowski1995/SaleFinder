package pl.atos.finalworkshop.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueShopNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueShopName {
    String message() default "Podany sklep już istnieje";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
