package pl.atos.finalworkshop.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.atos.finalworkshop.category.Category;
import pl.atos.finalworkshop.category.CategoryService;
import pl.atos.finalworkshop.user.User;

import java.util.List;
import java.util.Optional;

@Controller
public class EmailService {

    private final EmailSender emailSender;
    private CategoryService categoryService;

    @Autowired
    public EmailService(EmailSender emailSender, CategoryService categoryService) {
        this.emailSender = emailSender;
        this.categoryService = categoryService;
    }

    @RequestMapping("mail")
    public String send() {
        emailSender.sendEmail("lucjan003@gmail.com", "CodeCouple Newsletter", "hello");
        return "redirect:";
    }

    public void sendToCategoryObserver(Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            List<User> users = category.get().getUsers();
            for (User user : users) {
                emailSender.sendEmail(user.getEmail(),"Nowa promocja w kategorii: " +
                        category.get().getName(), "Witaj, pojawił się nowy przedmiot w kategorii, którą obserwujesz");
            }
        }
    }
}
