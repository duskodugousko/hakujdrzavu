package rs.euprava.gov.notifikator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import rs.euprava.gov.notifikator.model.User;
import rs.euprava.gov.notifikator.model.Vest;
import rs.euprava.gov.notifikator.service.VestService;

import java.util.List;

@Controller
@RequestMapping("/vesti")
public class VestController extends BaseController {

    private final String VEST = "vest/vest";
    private final String VESTI = "vest/vesti";

    @Autowired
    private VestService epsVestService;

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

        return NASLOV_VESTI;
    }

    @PostMapping
    public String vest(@SessionAttribute(required = false) User user,
                       @ModelAttribute(name = "vest") Vest vest, Model model) {

        if(user == null || user.getName() == null){
            return "redirect:/login";
        }

        String userName = user.getName();

        List<Vest> vesti = epsVestService.findAll(user.getName());
        model.addAttribute("vesti", vesti);

        if (vest == null) {
            return VESTI;
        }

        vest.setType(userName);
        epsVestService.save(vest);

        return "redirect:/vesti/lista";
    }

    @GetMapping("/lista")
    public String vesti(@SessionAttribute(required = false) User user, Model model) {

        if(user == null || user.getName() == null){
            return "redirect:/login";
        }
        List<Vest> vesti = epsVestService.findAll(user.getName());
        model.addAttribute("vesti", vesti);
        return VESTI;
    }

    @GetMapping("/vest")
    public String vest(@RequestParam(name = "id", defaultValue = "") Long id, Model model) {
        Vest vest;

        if (id == null) {
            vest = new Vest();
            model.addAttribute("vest", vest);

            return VEST;
        }

        vest = epsVestService.findOne(id);
        model.addAttribute("vest", vest);

        return VEST;
    }

    @DeleteMapping("/obrisiVest")
    @ResponseBody
    public void deleteVest(@RequestParam(name = "vestId", defaultValue = "") Long vestId) {
        if (vestId != null) {
            epsVestService.delete(vestId);
        }
    }
}
