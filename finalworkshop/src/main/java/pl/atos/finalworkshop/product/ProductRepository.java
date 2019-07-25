package pl.atos.finalworkshop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByName(String name);

    List<Product> findFirst10ByOrderByCreatedDesc();

    List<Product> findAllByCategoryId(Long id);

        @Query(nativeQuery = true, value = "select * from products " +
                " inner join shop on products.shop_id=shop.id" +
                " inner join shop_city on shop.id=shop_city.shopList_id" +
                " inner join city on city.id=shop_city.cities_id" +
                " where city.name = :cityName and products.name = :productName")
        List<Product> findByCityAndName(@Param("cityName") String cityName, @Param("productName") String productName);
}

