package pl.atos.finalworkshop.email;

import pl.atos.finalworkshop.user.User;

public interface EmailServiceInterface {

    void sendVerifyUserMail(User user, String contextPath);

    void sendToCategoryObserver(Long id);
}
