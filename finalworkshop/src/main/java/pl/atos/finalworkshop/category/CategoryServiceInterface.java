package pl.atos.finalworkshop.category;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceInterface {

    List<Category> findAll();

    Category save(Category category);

    Category findFirstByName(String name);

    Optional<Category> findById(Long id);
}
