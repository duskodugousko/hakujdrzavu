package rs.euprava.gov.notifikator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.euprava.gov.notifikator.model.Obavestenje;
import rs.euprava.gov.notifikator.model.Vest;
import rs.euprava.gov.notifikator.service.ObavestenjeService;
import rs.euprava.gov.notifikator.service.VestService;

import java.util.List;

@RestController
@RequestMapping("/epsRest")
public class EpsRestController {

//    @Autowired
//    private ObavestenjeService obavestenjeService;
//
//    @Autowired
//    private VestService epsVestService;
//
//    @ResponseBody
//    @RequestMapping("/obavestenja")
//    public List<Obavestenje> getObavestenja() {
//
//        List<Obavestenje> obavestenja = obavestenjeService.findAll();
//
//        return obavestenja;
//    }
//
//    @ResponseBody
//    @RequestMapping("/vesti")
//    public List<Vest> getVesti() {
//        List<Vest> vesti = epsVestService.findAll();
//
//        return vesti;
//    }
}
