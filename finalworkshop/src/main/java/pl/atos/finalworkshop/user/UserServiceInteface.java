package pl.atos.finalworkshop.user;

import java.util.List;

public interface UserServiceInteface {

    User findByUserName(String name);

    void saveUser(User user);

    List<User> findAllByOrderByProductsDesc();
}
