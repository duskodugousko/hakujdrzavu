package rs.euprava.gov.notifikator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import rs.euprava.gov.notifikator.model.User;


@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class MainController extends BaseController{

    @GetMapping
    public String login(Model model) {

        model.addAttribute("user", new User());
        model.addAttribute("login", true);
        return "login";
    }
}
