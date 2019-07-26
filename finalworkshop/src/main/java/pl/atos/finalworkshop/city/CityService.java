package pl.atos.finalworkshop.city;

import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CityService implements CityServiceInterface {

    CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> finById(Long id) {
        return cityRepository.findCityByShop(id);
    }

    @Override
    public City findFirstByName(String name) {
        return cityRepository.findFirstByName(name);
    }

    @Override
    public void save(String cityName) {
        if (cityRepository.findFirstByName(cityName) == null) {
            City city = new City();
            city.setName(cityName);
            cityRepository.save(city);
        }
    }
}
