package pl.atos.finalworkshop.region;

import pl.atos.finalworkshop.city.City;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region")
    private List<City> cities= new ArrayList<>();
}
