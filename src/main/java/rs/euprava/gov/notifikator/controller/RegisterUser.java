package rs.euprava.gov.notifikator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import rs.euprava.gov.notifikator.model.User;

@Controller
@SessionAttributes("user")
@RequestMapping("/register")
public class RegisterUser extends BaseController{

    private final String EPS = "eps";
    private final String VODOVOD = "vodovod";

    @PostMapping
    public String addUserToSession(@ModelAttribute("user") User user) {
        if (user == null) {
            return "redirect:/login";
        }

        String userName = user.getName();
        String password = user.getPassword();

        if (userName.equalsIgnoreCase(EPS) && password.equalsIgnoreCase(EPS)) {
            return "redirect:/vesti/lista";
        } else if (userName.equalsIgnoreCase(VODOVOD) && password.equalsIgnoreCase(VODOVOD)) {
            return "redirect:/vesti/lista";
        }
        return "redirect:/login";
    }
}
