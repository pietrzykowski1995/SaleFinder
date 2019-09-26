package pl.atos.finalworkshop.shop;

import java.util.List;

public interface ShopServiceInterface {

    List<Shop> findAll();

    void save(Shop shop);

    Shop findFirstByName(String givenShopName);

    Shop findFirstById(Long id);

    void addCity(String cityName, Shop shop);
}
