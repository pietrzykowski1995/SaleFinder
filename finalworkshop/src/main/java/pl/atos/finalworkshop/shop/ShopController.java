package pl.atos.finalworkshop.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping("shops")
    public String goToShopList() {
        return "shops";
    }
}
