package pl.atos.finalworkshop.category;

import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.UniqueElements;
import pl.atos.finalworkshop.product.Product;
import pl.atos.finalworkshop.validators.UniqueCateogryName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UniqueCateogryName
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();


    @Formula("(select count(*) from products where products.category_id = id)")
    private int productQuantity;

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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
