package rs.euprava.gov.notifikator.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rs.euprava.gov.notifikator.model.User;

@Controller
@RequestMapping("/izbor")
public class IzborController extends BaseController{

    @RequestMapping
    public String izbor() {
        return "izbor";
    }
}
