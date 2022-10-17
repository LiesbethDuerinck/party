package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;
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
    private final int mySpecialNumber = 35;
    private final Venue[] venues ={
            new Venue("Bocadero", "https://www.bocadero.be/nl/#", "Antwerpen", false, true, true),
            new Venue("Jardim", "https://www.jardim-antwerp.be/", "Antwerpen", false, true, true),
            new Venue("Zomerfabriek", "https://zomerfabriek.be/", "Antwerpen", true, true, false),
            new Venue("Zomerbar", "https://www.zva.be/zomerbar-circussen", "Antwerpen", true, true, true)
    };

    @GetMapping(value = {"/", "/home", "/home/"}) //deze annotatie vertelt Spring om deze methode aan te roepen als de Application Server de request "/" binnenkrijgt
    public String home(Model model) {
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        return "home";                              //de view "home.html" zal gerendered worden
    }
    @GetMapping("/pay")                                                     //elke url mapping moet uniek zijn binnen de springapplicatie
    public String pay(Model model){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);

        Boolean weekend = false;
        if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY||c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            weekend = true;
        }

        c.add(Calendar.DATE,5);
        Date paydate = c.getTime();

        model.addAttribute("weekend", weekend);
        model.addAttribute("paydate", format.format(paydate));
        return "pay";
    }

    @GetMapping("/about")                               //een methode in de controller die requests behandelt. Spring herkent ze door @GetMapping = Request Handler.
    public String about() {
        return "about";
    }

    @GetMapping("/venuelist")
    public String venuelist(Model model){
        model.addAttribute("venues", venues);
        return "venuelist";
    }

    @GetMapping({"/venuedetails/{venuename}", "/venuedetails"})
    public String venuedetails(Model model,
                               @PathVariable(required = false) String venuename){       //via een PathVariable kan je data doorgeven van een page naar een andere

        model.addAttribute("venuename", venuename);           //volledige array wordt in het model gestoken
        return "venuedetails";
    }

    @GetMapping({"/venuedetailsbyindex","/venuedetailsbyindex/","/venuedetailsbyindex/{venueindex}"})
    public String venuedetailsbyindex(Model model, @PathVariable(required = false) String venueindex){
        Venue venue = null;
        if(venueindex !=null && Integer.parseInt(venueindex)%1 == 0 && Integer.parseInt(venueindex)>= 0 && Integer.parseInt(venueindex)< venues.length)
        {
            venue = venues[Integer.parseInt(venueindex)];
        }

        if(venueindex != null && Integer.parseInt(venueindex)%1 == 0 && Integer.parseInt(venueindex)>= 0 && Integer.parseInt(venueindex)< venues.length)
        {

            venue = venues[Integer.parseInt(venueindex)];
        }
        int prevIndex = Integer.parseInt(venueindex)-1;
        if(prevIndex<0){

            prevIndex = venues.length - 1;
        }

        int nextIndex = Integer.parseInt(venueindex)+1;

        if(nextIndex > venues.length-1)
        {
            nextIndex = 0;
        }


        model.addAttribute("venue", venue);
        model.addAttribute("prevIndex", prevIndex);
        model.addAttribute("nextIndex", nextIndex);
        return "venuedetailsbyindex";
    }

}