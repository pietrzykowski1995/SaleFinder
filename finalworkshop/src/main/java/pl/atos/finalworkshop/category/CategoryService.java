package pl.atos.finalworkshop.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.atos.finalworkshop.user.User;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements CategoryServiceInterface {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        List<Category> allCategories = categoryRepository.findAll();
        Collections.sort(allCategories, new CategorySortByProductQuantity());
        return allCategories;
    }

    @Override
    public Category save(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category findFirstByName(String name) {
        return categoryRepository.findFirstByName(name);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void addObserver(Long id, User user) {
        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            category.get().addUser(user);
            categoryRepository.save(category.get());
        }
    }
}
