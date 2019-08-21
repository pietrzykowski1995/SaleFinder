package pl.atos.finalworkshop.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {

    private final EmailSender emailSender;
    @Autowired
    public EmailController(EmailSender emailSender){
        this.emailSender = emailSender;
    }
    @RequestMapping("mail")
    public String send() {
        emailSender.sendEmail("lucjan003@gmail.com", "CodeCouple Newsletter", "hello");
        return "redirect:";
    }
}
