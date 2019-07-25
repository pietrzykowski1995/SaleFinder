package pl.atos.finalworkshop.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.atos.finalworkshop.category.Category;

import java.util.List;


@Service
public class ShopService implements ShopServiceInterface {

    ShopRepository shopRepository;

    @Autowired
    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }
}
