package pl.atos.finalworkshop.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    Shop findFirstByName(String givenShopName);

    Shop findFirstById(Long id);
}
