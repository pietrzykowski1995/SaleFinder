package pl.atos.finalworkshop.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.atos.finalworkshop.city.City;
import pl.atos.finalworkshop.city.CityService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ShopController {

    ShopService shopService;
    CityService cityService;

    @Autowired
    public ShopController(ShopService shopService, CityService cityService) {
        this.shopService = shopService;
        this.cityService = cityService;
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

    @GetMapping("shop/edit/{id}")
    public String editShop(@PathVariable("id") Long id, Model model) {
        List<City> cities = cityService.finById(id);
        model.addAttribute("cities", cities);
        model.addAttribute("id", id);


        return "city-list";
    }

    @PostMapping("add-city/{id}")
    public String addShop(@RequestParam("cityName") String cityName, @PathVariable("id") Long id) {

        Shop shop = shopService.findFirstById(id);
        cityService.save(cityName);
        shopService.addCity(cityName,shop);
        return "redirect:/shops";
    }
}
