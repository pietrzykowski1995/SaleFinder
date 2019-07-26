package pl.atos.finalworkshop.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.atos.finalworkshop.city.City;
import pl.atos.finalworkshop.city.CityRepository;

import java.util.List;


@Service
public class ShopService implements ShopServiceInterface {


    ShopRepository shopRepository;
    CityRepository cityRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository, CityRepository cityRepository) {
        this.shopRepository = shopRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public void save(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public Shop findFirstByName(String givenShopName) {
        return shopRepository.findFirstByName(givenShopName);
    }

    @Override
    public Shop findFirstById(Long id) {
        return shopRepository.findFirstById(id);
    }

    @Override
    public void addCity(String cityName, Shop shop) {
        City city = cityRepository.findFirstByName(cityName);
        shop.getCities().add(city);
        shopRepository.save(shop);
    }


}
