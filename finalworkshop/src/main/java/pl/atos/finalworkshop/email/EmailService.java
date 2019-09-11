package pl.atos.finalworkshop.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.atos.finalworkshop.category.Category;
import pl.atos.finalworkshop.category.CategoryService;
import pl.atos.finalworkshop.user.User;
import pl.atos.finalworkshop.user.VerificationToken;

import javax.persistence.OneToOne;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Configuration
public class EmailService implements EmailServiceInterface {

    private final EmailSender emailSender;
    private CategoryService categoryService;

    @Autowired
    public EmailService(EmailSender emailSender, CategoryService categoryService) {
        this.emailSender = emailSender;
        this.categoryService = categoryService;
    }

    @Async
    @Override
    public void sendToCategoryObserver(Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            List<User> users = category.get().getUsers();
            for (User user : users) {
                emailSender.sendEmail(user.getEmail(), "Nowa promocja w kategorii: " +
                        category.get().getName(), "Witaj, pojawił się nowy przedmiot w kategorii, którą obserwujesz");
            }
        }
    }

    @Async
    @Override
    public void sendVerifyUserMail(User user, String url) {

        String token= UUID.randomUUID().toString();
        VerificationToken verificationToken=new VerificationToken(token, user);

        emailSender.sendEmail(user.getEmail(), "Potwierdź rejestrację w portalu",
                "WItaj, potwierdź rejestrację na portalu SaleFinder klikając na poniższy link: /n" +
                url + "?token=" + token);
    }
}
