package pl.atos.finalworkshop.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.atos.finalworkshop.category.Category;

import javax.validation.Valid;

@Controller
public class ShopController {

    ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("shops")
    public String goToShopList(Model model) {
        model.addAttribute("shops", shopService.findAll());
        return "shops";
    }

    @GetMapping("create-shop")
    public String createShopForm(Model model) {
        model.addAttribute("shop", new Shop());
        return "create-shop";
    }

    @PostMapping("create-shop")
    public String createShop(@ModelAttribute("shop") @Valid Shop shop,
                                 BindingResult errors) {

        if (errors.hasErrors()) {
            return "create-shop";
        } else {
            shopService.save(shop);
            return "redirect:shops";
        }
    }
}
