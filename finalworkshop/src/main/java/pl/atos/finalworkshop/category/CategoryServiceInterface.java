package pl.atos.finalworkshop.category;

import java.util.List;

public interface CategoryServiceInterface {

    List<Category> findAll();

    Category save(Category category);

    Category findFirstByName(String name);
}
