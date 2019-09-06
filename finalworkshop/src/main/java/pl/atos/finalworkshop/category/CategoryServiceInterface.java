package pl.atos.finalworkshop.category;

import pl.atos.finalworkshop.user.User;

import java.util.List;
import java.util.Optional;

public interface CategoryServiceInterface {

    List<Category> findAll();

    Category save(Category category);

    Category findFirstByName(String name);

    Optional<Category> findById(Long id);

    void addObserver(Long id, User user);
}
