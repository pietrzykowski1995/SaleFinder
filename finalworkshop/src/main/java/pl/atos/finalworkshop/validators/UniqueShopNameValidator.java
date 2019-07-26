package pl.atos.finalworkshop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.atos.finalworkshop.shop.ShopService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueShopNameValidator implements ConstraintValidator<UniqueShopName, String> {
    public void initialize(UniqueShopName constraint) {
    }

    @Autowired
    ShopService shopService;

    @Override
    public boolean isValid(String givenShopName, ConstraintValidatorContext context) {

        if (shopService == null) {
            return true;
        }

        if (shopService.findFirstByName(givenShopName) != null) {
            return false;
        }
        return true;
    }
}
