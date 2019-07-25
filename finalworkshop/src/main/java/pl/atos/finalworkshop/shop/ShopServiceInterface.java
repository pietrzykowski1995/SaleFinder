package pl.atos.finalworkshop.shop;

import pl.atos.finalworkshop.category.Category;

import java.util.List;

public interface ShopServiceInterface {

    List<Shop> findAll();

    Shop save(Shop shop);
}
