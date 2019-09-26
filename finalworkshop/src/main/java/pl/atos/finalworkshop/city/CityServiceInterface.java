package pl.atos.finalworkshop.city;

import java.util.List;

public interface CityServiceInterface {

    List<City> finById(Long id);

    City findFirstByName(String name);

    void save(String cityName);
}
