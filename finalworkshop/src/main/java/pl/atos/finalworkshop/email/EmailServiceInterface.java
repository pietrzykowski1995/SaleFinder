package pl.atos.finalworkshop.email;

import org.springframework.scheduling.annotation.Async;
import pl.atos.finalworkshop.user.User;

public interface EmailServiceInterface {

    void sendVerifyUserMail(User user, String contextPath);

    void sendToCategoryObserver(Long id);
}
