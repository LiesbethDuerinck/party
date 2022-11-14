package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Artist;
import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.ArtistRepository;
import be.thomasmore.party.repositories.VenueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Controller
public class HomeController {
    private final int mySpecialNumber = 729;
    private final Venue [] venues = {
            new Venue(1,"Bocadero", "https://www.bocadero.be/nl/#", "Antwerpen", false, true, true),
            new Venue(2,"Jardim", "https://www.jardim-antwerp.be/", "Antwerpen", false, true, true),
            new Venue(3,"Zomerfabriek", "https://zomerfabriek.be/", "Antwerpen", true, true, false),
            new Venue(4,"Zomerbar", "https://www.zva.be/zomerbar-circussen", "Antwerpen", true, true, true),
            new Venue(5, "BAR-N", "http://bar-n.be/index.html", "Essen", true, false, true)
    };
    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping(value = {"/", "/home", "/home/"})
    public String home (Model model){
        model.addAttribute("mySpecialNumber", mySpecialNumber);
        return "home";
    }

    @GetMapping("/pay")
    public String pay(Model model){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        Boolean weekend = false;
        if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY )
        {
            weekend = true;
        }
        c.add(Calendar.DATE,5);
        Date paydate = c.getTime();
        model.addAttribute("paydate", format.format(paydate));
        model.addAttribute("weekend",weekend);
        return "pay";
    }
    @GetMapping("/about")
    public String about (){
        return "about";
    }

    @GetMapping("/venuelist")
    public String venuelist (Model model){
        Iterable<Venue> venues = venueRepository.findAll();
        model.addAttribute("venues",venues);
        return "venuelist";
    }

    @GetMapping("/artistlist")
    public String artistlist(Model model){
        Iterable<Artist> artists = artistRepository.findAll();
        model.addAttribute("artists", artists);
        return "artistlist";
    }
    @GetMapping("/venuelist/parking/{isParking}")
    public String venuelistIsParking(Model model, @PathVariable Optional<String> isParking){
        boolean parking = false;
        Integer myParking = 2;
        Iterable<Venue> venueList = venueRepository.findAll();

        if(isParking.isPresent()){
            myParking = Integer.parseInt(isParking.get());
        }

        switch (myParking){
            case 0:
                venueList = venueRepository.findByParking(false);
                break;
            case 1:
                venueList = venueRepository.findByParking(true);
                break;
            default:
        }
        model.addAttribute("venues", venueList);
        model.addAttribute("parking", myParking);
        return "venuelist";
    }

    @GetMapping("/venuelist/foodAvailable/{isFoodAvailable}")
    public String venuelistIsFoodAvailable(Model model, @PathVariable Optional<String> isFoodAvailable){
        boolean foodAvailable = false;
        Integer myFood = 2;
        Iterable<Venue> venueList = venueRepository.findAll();

        if(isFoodAvailable.isPresent()){
            myFood = Integer.parseInt(isFoodAvailable.get());
        }

        switch (myFood){
            case 0:
                venueList = venueRepository.findByFoodAvailable(false);
                break;
            case 1:
                venueList = venueRepository.findByFoodAvailable(true);
                break;
            default:
        }
        model.addAttribute("venues", venueList);
        model.addAttribute("foodAvailable", myFood);
        return "venuelist";
    }

    @GetMapping("/venuelist/kidsFriendly/{isKidsFriendly}")
    public String venuelistIsKidsFriendly(Model model, @PathVariable Optional<String> isKidsFriendly){
        boolean kidsFriendly = false;
        Integer myKids = 2;
        Iterable<Venue> venueList = venueRepository.findAll();

        if(isKidsFriendly.isPresent()){
            myKids = Integer.parseInt(isKidsFriendly.get());
        }

        switch (myKids){
            case 0:
                venueList = venueRepository.findByKidsFriendly(false);
                break;
            case 1:
                venueList = venueRepository.findByKidsFriendly(true);
                break;
            default:
        }
        model.addAttribute("venues", venueList);
        model.addAttribute("kidsFriendly", myKids);
        return "venuelist";
    }


    @GetMapping({"/artistdetailsbyid","/artistdetailsbyid/{artistid}"})
    public String artistdetailsbyid(Model model, @PathVariable(required = false) String artistid){

        Optional oArtist = null;
        Artist artist = null;
        int artistCount = 0;

        artistCount = (int) artistRepository.count();

        oArtist = artistRepository.findById(Integer.parseInt(artistid));
        if(oArtist.isPresent()){
            artist = (Artist) oArtist.get();
        }

        int nextId = Integer.parseInt(artistid)+1;
        if(nextId > artistCount){
            nextId = 1;
        }

        int prevId = Integer.parseInt(artistid)-1;
        if(prevId < 1){
            prevId = artistCount;
        }

        model.addAttribute("artist", artist);
        model.addAttribute("prevIndex", prevId);
        model.addAttribute("nextIndex", nextId);
        return "artistdetailsbyid";
    }

    @GetMapping({"/venuedetailsbyid","/venuedetailsbyid/","/venuedetailsbyid/{venueid}"})
    public String venuedetailsbyid(Model model, @PathVariable(required = false) String venueid){

        Optional oVenue = null;
        Venue venue = null;
        int venueCount = 0;

        venueCount = (int) venueRepository.count();

        try {
            oVenue = venueRepository.findById(Integer.parseInt(venueid));
        } catch (NumberFormatException e){
            return null;
        }

        if(oVenue.isPresent()){
            venue = (Venue) oVenue.get();
        }

        int prevId = Integer.parseInt(venueid)-1;
        if(prevId<1){
            prevId = venueCount;
        }

        int nextId = Integer.parseInt(venueid)+1;
        if(nextId > venueCount)
        {
            nextId = 1;
        }

        model.addAttribute("venue", venue);
        model.addAttribute("prevIndex", prevId);
        model.addAttribute("nextIndex", nextId);
        return "venuedetailsbyid";
    }

    }

