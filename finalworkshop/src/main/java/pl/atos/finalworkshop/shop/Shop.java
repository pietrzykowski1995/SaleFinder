package pl.atos.finalworkshop.shop;

import org.hibernate.annotations.Formula;
import pl.atos.finalworkshop.city.City;
import pl.atos.finalworkshop.product.Product;
import pl.atos.finalworkshop.validators.UniqueShopName;

import javax.persistence.*;
import java.util.List;

@Entity
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "shop")
    private List<Product> products;

    @UniqueShopName
    private String name;

    @ManyToMany
    private List<City> cities;

    @Formula("(select count(*) from products where products.shop_id = id)")
    private int productQuantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
