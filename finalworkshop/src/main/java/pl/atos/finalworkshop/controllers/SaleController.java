package pl.atos.finalworkshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.atos.finalworkshop.category.Category;
import pl.atos.finalworkshop.category.CategoryService;
import pl.atos.finalworkshop.product.Product;
import pl.atos.finalworkshop.product.ProductService;
import pl.atos.finalworkshop.shop.Shop;
import pl.atos.finalworkshop.shop.ShopService;

import javax.validation.Valid;
import java.util.List;


@Controller
public class SaleController {

    ProductService productService;
    CategoryService categoryService;
    ShopService shopService;

    @Autowired
    public SaleController(ProductService productService, CategoryService categoryService, ShopService shopService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.shopService = shopService;
    }

    @GetMapping("new-post")
    public String goToNewSaleView(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);

        return "new-post-page";
    }

    @PostMapping("new-post")
    public String saveSale(@ModelAttribute("product") @Valid Product product,
                           BindingResult errors) {

        if(errors.hasErrors()) {
            return "new-post-page";
        }

            productService.saveSale(product);
        return "redirect:";
    }

    @PostMapping("search")
    public String searchByName(@RequestParam("productName") String productName, @RequestParam("cityName") String cityName, Model model) {
        List<Product> products;

            if(cityName.isEmpty() && productName.isEmpty()){

            }
        else if (cityName.isEmpty()) {
            products = productService.findByName(productName);
            model.addAttribute("products", products);
        } else {
            products = productService.findByCityAndName(cityName, productName);
            model.addAttribute("products", products);
        }
        return "product-list";
    }

    @GetMapping("/category/{categoryId}")
    public String goToCateogryList(@PathVariable("categoryId") Long id, Model model) {
        List<Product> products = productService.findByCategoryId(id);
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("mega-sales")
    public String goToMegaSales(Model model) {

        return "mega-sales";
    }


    @ModelAttribute("categories")
    public List<Category> allCategories() {
        return this.categoryService.findAll();
    }

    @ModelAttribute("shops")
    public List<Shop> allShops() {
        return shopService.findAll();
    }
}
