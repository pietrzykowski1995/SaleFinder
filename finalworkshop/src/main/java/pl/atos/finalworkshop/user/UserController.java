package pl.atos.finalworkshop.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import pl.atos.finalworkshop.email.EmailService;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    private final EmailService emailService;

    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping("create-user")
    public String log(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create-user";
    }

    @PostMapping("create-user")
    public String logUser(@ModelAttribute("user") @Valid User user, BindingResult result, WebRequest request) {
        if (result.hasErrors()) {
            return "create-user";
        }
        userService.saveUser(user);
        String appUrl = request.getContextPath();
        emailService.sendVerifyUserMail(user, appUrl);
        return "redirect:";
    }

    @GetMapping("create-user/confirm")
    public String confirmCreateUser(@RequestParam("token") String token) {

        VerificationToken verificationToken = userService.getVerificationToken(token);

        if (verificationToken == null) {
            //condition when token has expired or its wrong
        }

        User user = verificationToken.getUser();

        // check if link has not expired

        user.setEnabled();
        userService.saveUser(user);
        return "login";
    }


    @GetMapping("login")
    public String login() {
        return "login";
    }

}
