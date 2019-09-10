package pl.atos.finalworkshop.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("create-user")
    public String log(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "create-user";
    }

    @PostMapping("create-user")
    public String logUser(@ModelAttribute("user") @Valid User user, BindingResult result) {

        if(result.hasErrors()) {
            return "create-user";
        }
        userService.saveUser(user);
        return "redirect:";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

}
