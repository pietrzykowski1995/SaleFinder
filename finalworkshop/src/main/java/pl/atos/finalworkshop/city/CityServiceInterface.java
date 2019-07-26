package pl.atos.finalworkshop.city;

import pl.atos.finalworkshop.shop.Shop;

import java.util.List;

public interface CityServiceInterface {

    List<City> finById(Long id);

    City findFirstByName(String name);


    void save(String cityName);
}
