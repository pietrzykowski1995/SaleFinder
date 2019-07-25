package pl.atos.finalworkshop.product;


import java.util.List;

public interface ProductServiceInterface {

    Product saveSale(Product product);

    List<Product> findByName(String name);

    List<Product> findTop10();

    List<Product> findByCategoryId(Long id);

    List<Product> findByCityAndName(String cityName, String productName);




}
