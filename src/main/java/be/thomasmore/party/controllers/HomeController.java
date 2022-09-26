package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
     private final int mySpecialNumber = 35;
    
    @GetMapping(value = {"/", "/home", "/home/"})
    public String home(Model model) {
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        return "home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/venuedetails/{venuename}")
    public String venuedetails(Model model, @PathVariable String venuename) {
        model.addAttribute("venuename", venuename);
        return "venuedetails";
    }
}