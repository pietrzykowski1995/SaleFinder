package pl.atos.finalworkshop.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class FutureDateValidator implements ConstraintValidator<FutureDate, LocalDate> {
   public void initialize(FutureDate constraint) {
   }

   @Override
   public boolean isValid(LocalDate givenDate, ConstraintValidatorContext context) {
      return givenDate!=null && givenDate.isAfter(LocalDate.now());
   }

}
