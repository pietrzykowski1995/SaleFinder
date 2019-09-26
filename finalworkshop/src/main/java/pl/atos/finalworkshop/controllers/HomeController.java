package pl.atos.finalworkshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.atos.finalworkshop.category.Category;
import pl.atos.finalworkshop.category.CategoryService;
import pl.atos.finalworkshop.product.Product;
import pl.atos.finalworkshop.product.ProductService;

import java.util.List;

@Controller
public class HomeController {

    CategoryService categoryService;
    ProductService productService;

    @Autowired
    public HomeController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @RequestMapping("")
    public String goHomePage(Model model) {
        model.addAttribute("product", new Product());
        return "index";
    }

    @ModelAttribute("categories")
    public List<Category> allCategories() {
        return this.categoryService.findAll();
    }

    @ModelAttribute("top10Products")
    private  List<Product> top10Products() { return this.productService.findTop10(); }
}
