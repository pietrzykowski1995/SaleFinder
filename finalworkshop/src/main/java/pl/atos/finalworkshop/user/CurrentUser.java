package pl.atos.finalworkshop.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {

    private final pl.atos.finalworkshop.user.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       pl.atos.finalworkshop.user.User user) {
        super(username, password, authorities);
        this.user = user;
    }
    public pl.atos.finalworkshop.user.User getUser() {return user;}
}
