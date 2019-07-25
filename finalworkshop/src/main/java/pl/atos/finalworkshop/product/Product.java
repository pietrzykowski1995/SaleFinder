package pl.atos.finalworkshop.product;

import org.hibernate.validator.constraints.NotEmpty;
import pl.atos.finalworkshop.category.Category;
import pl.atos.finalworkshop.shop.Shop;
import pl.atos.finalworkshop.validators.FutureDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty( message = "Nazwa nie może być pusta")
    private String name;

    @ManyToOne
    private Category category;

    private double price;

    private double priceBeforeSale;

    private boolean saleType;

    @ManyToOne
    private Shop shop;

    private LocalDateTime created;

    @FutureDate
    private LocalDate expire;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPriceBeforeSale() {
        return priceBeforeSale;
    }

    public void setPriceBeforeSale(double priceBeforeSale) {
        this.priceBeforeSale = priceBeforeSale;
    }

    public boolean isSaleType() {
        return saleType;
    }

    public void setSaleType(boolean saleType) {
        this.saleType = saleType;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDate getExpire() {
        return expire;
    }

    public void setExpire(LocalDate expire) {
        this.expire = expire;
    }
}