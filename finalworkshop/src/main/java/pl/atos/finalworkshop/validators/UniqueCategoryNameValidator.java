package pl.atos.finalworkshop.validators;

import org.springframework.beans.factory.annotation.Autowired;
import pl.atos.finalworkshop.category.Category;
import pl.atos.finalworkshop.category.CategoryService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCategoryNameValidator implements ConstraintValidator<UniqueCateogryName, String> {
    public void initialize(UniqueCateogryName constraint) {
    }

    @Autowired
    CategoryService categoryService;

    @Override
    public boolean isValid(String givenCategoryName, ConstraintValidatorContext context) {

        if(categoryService==null) {
            return true;
        }

        if (categoryService.findFirstByName(givenCategoryName) != null) {
            return false;
        } else {
            return true;
        }
    }
}
