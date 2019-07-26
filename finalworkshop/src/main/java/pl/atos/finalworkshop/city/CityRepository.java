package pl.atos.finalworkshop.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(nativeQuery = true, value = "select * from city " +
            " inner join shop_cities on city.id=shop_cities.cities_id" +
            " inner join shop on shop.id=shop_cities.shop_list_id" +
            " where shop.id = :id")
    List<City> findCityByShop(@Param("id") Long id);

    City findFirstByName(String name);
}
