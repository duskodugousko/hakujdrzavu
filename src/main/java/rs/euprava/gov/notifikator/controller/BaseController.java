package rs.euprava.gov.notifikator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import rs.euprava.gov.notifikator.model.User;

@Controller
public class BaseController {

    protected final String LOGO_EPS = "eps-logo.png";
    protected final String LOGO_VODOVOD = "vodovod-logo.png";
    protected final String LOGO_KORISNIK = "korisnik.png";

    protected final String NASLOV_LOGIN = "PRIJAVA NA SISTEM";
    protected final String NASLOV_VESTI = "VESTI";
    protected final String NASLOV_OBAVESTENJA = "OBAVEŠTENJA";


    @ModelAttribute("logoName")
    public String logName(@SessionAttribute(required = false) User user) {

        return LOGO_KORISNIK;
    }

    @ModelAttribute("naslov")
    public String naslov() {

        return NASLOV_LOGIN;
    }

    @ModelAttribute("login")
    public boolean user() {

        return false;
    }
}
