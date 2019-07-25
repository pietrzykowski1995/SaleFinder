package pl.atos.finalworkshop.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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



}
