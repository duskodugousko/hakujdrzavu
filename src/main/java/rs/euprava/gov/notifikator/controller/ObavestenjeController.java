package rs.euprava.gov.notifikator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import rs.euprava.gov.notifikator.model.Obavestenje;
import rs.euprava.gov.notifikator.model.User;
import rs.euprava.gov.notifikator.service.ObavestenjeService;

import java.util.List;

@Controller
@RequestMapping("obavestenja")
public class ObavestenjeController extends BaseController{

    private final String OBAVESTENJE = "obavestenje/obavestenje";
    private final String OBAVESTENJA = "obavestenje/obavestenja";

    @Autowired
    private ObavestenjeService obavestenjeService;

    @ModelAttribute("logoName")
    public String logName(@SessionAttribute(required = false) User user) {

        if(user == null || user.getName() == null){
            return "redirect:/login";
        }

        if(user.getName().equalsIgnoreCase("EPS")){
            return LOGO_EPS;
        }

        else if(user.getName().equalsIgnoreCase("VODOVOD")){
            return LOGO_VODOVOD;
        }

        return LOGO_KORISNIK;
    }

    @ModelAttribute("naslov")
    public String naslov() {

        return NASLOV_OBAVESTENJA;
    }

    @PostMapping
    public String obavestenje(@SessionAttribute(required = false) User user,
                              @ModelAttribute Obavestenje obavestenje, Model model) {




        if (obavestenje == null) {
            return OBAVESTENJE;
        }

        if(user == null || user.getName() == null){
            return "redirect:/login";
        }

        List<Obavestenje> obavestenja = obavestenjeService.findAll(user.getName());
        model.addAttribute("obavestenja", obavestenja);

        obavestenje.setType(user.getName());
        obavestenjeService.save(obavestenje);

        return "redirect:/obavestenja/lista";
    }

    @GetMapping("/lista")
    public String obavestenja(@SessionAttribute(required = false) User user, Model model) {

        if(user == null || user.getName() == null){
            return "redirect:/login";
        }

        List<Obavestenje> obavestenja = obavestenjeService.findAll(user.getName());

        model.addAttribute("obavestenja", obavestenja);
        return OBAVESTENJA;
    }

    @GetMapping("/obavestenje")
    public String obavestenje(@RequestParam(name = "id", defaultValue = "") Long id, Model model) {
        Obavestenje obavestenje;

        if (id == null) {
            obavestenje = new Obavestenje();
            model.addAttribute("obavestenje", obavestenje);

            return OBAVESTENJE;
        }
        obavestenje = obavestenjeService.findOne(id);
        model.addAttribute("obavestenje", obavestenje);

        return OBAVESTENJE;
    }

    @DeleteMapping("/obrisiObavestenje")
    @ResponseBody
    public void deleteObavestenje(@RequestParam(name = "obavestenjeId", defaultValue = "") Long obavestenjeId) {
        if (obavestenjeId != null) {
            obavestenjeService.delete(obavestenjeId);
        }
    }


}
