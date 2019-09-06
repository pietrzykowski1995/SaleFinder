package pl.atos.finalworkshop.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.atos.finalworkshop.user.CurrentUser;

import javax.validation.Valid;

@Controller
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("categories")
    public String goToCategories(Model model, @AuthenticationPrincipal CurrentUser currentUser) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("observeCategories", currentUser.getUser().getCategories());
        return "categories";
    }

    @GetMapping("create-category")
    public String createCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "create-category";
    }

    @PostMapping("create-category")
    public String createCategory(@ModelAttribute("category") @Valid Category category,
                                 BindingResult errors) {

        if (errors.hasErrors()) {
            return "create-category";
        } else {
            categoryService.save(category);
            return "redirect:categories";
        }
    }
}
