package pl.atos.finalworkshop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveSale(Product product) {
        product.setCreated(LocalDateTime.now());
        productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAllByName(name);
    }

    @Override
    public List<Product> findTop10() {
        return productRepository.findFirst10ByOrderByCreatedDesc();
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return productRepository.findAllByCategoryId(id);
    }

    @Override
    public List<Product> findByCityAndName(String cityName, String productName) {
        return productRepository.findByCityAndName(cityName, productName);
    }
}
