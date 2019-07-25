package pl.atos.finalworkshop.city;

import pl.atos.finalworkshop.region.Region;
import pl.atos.finalworkshop.shop.Shop;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Region region;

    @ManyToMany(mappedBy = "cities")
    private List<Shop> shopList = new ArrayList<>();
}
