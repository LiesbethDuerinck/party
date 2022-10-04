//Controller behandelt de user requests

package be.thomasmore.party.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;                //om data van de Controller naar de View te sturen. MVC = Model, View, Controller
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller         //deze annotatie vertelt Spring dat deze class een Controller is
public class HomeController {
     private final int mySpecialNumber = 35;        //final, want dit is een constante die nooit meer wordt veranderd. Nooit variabelen bijhouden in Controller!
     private final String[] venueNames ={"De Loods", "De Club", "De Hangar", "Cuba Libre", "Zapoi", "Kuub"};        //altijd private + final

    
    @GetMapping(value = {"/", "/home", "/home/"}) //deze annotatie vertelt Spring om deze methode aan te roepen als de Application Server de request "/" binnenkrijgt
    public String home(Model model) {
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        return "home";                              //de view "home.html" zal gerendered worden
    }

    @GetMapping("/about")                               //een methode in de controller die requests behandelt. Spring herkent ze door @GetMapping = Request Handler.
                                                            // Heeft steeds als return de naam van de View. View = wat de gebruiker zal zien
    public String about() {
        return "about";
    }

    @GetMapping(value = {"/venuedetails/{venueName}", "/venuedetails"})
    public String venuedetails(Model model,
                               @PathVariable(required = false) String venueName){       //via een PathVariable kan je data doorgeven van een page naar een andere
                                                                                        //venueName = wat tussen accolades staat in eerste regel
        model.addAttribute("venueNames", venueNames);           //volledige array wordt in het model gestoken
        return "venuedetails";
    }

    @GetMapping("/pay")                                                     //elke url mapping moet uniek zijn binnen de springapplicatie
    public String pay(Model model){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        model.addAttribute("today",format.format(today));
        c.add(Calendar.DATE,5);
        Date paydate = c.getTime();
        model.addAttribute("paydate", format.format(paydate));
        return "pay";
    }

}