package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import be.thomasmore.party.model.Artist;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import be.thomasmore.party.repositories.VenueRepository;
import be.thomasmore.party.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class VenueController {
    private final Venue [] venues = {
            new Venue(1,"Bocadero", "https://www.bocadero.be/nl/#", "Antwerpen", false, true, true),
            new Venue(2,"Jardim", "https://www.jardim-antwerp.be/", "Antwerpen", false, true, true),
            new Venue(3,"Zomerfabriek", "https://zomerfabriek.be/", "Antwerpen", true, true, false),
            new Venue(4,"Zomerbar", "https://www.zva.be/zomerbar-circussen", "Antwerpen", true, true, true),
            new Venue(5, "BAR-N", "http://bar-n.be/index.html", "Essen", true, false, true)
    };

    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venuelist")
    public String venuelist (Model model){
        Iterable<Venue> venues = venueRepository.findAll();
        model.addAttribute("venues",venues);
        return "venuelist";
    }



    @GetMapping({"/venuedetailsbyid","/venuedetailsbyid/","/venuedetailsbyid/{venueid}"})
    public String venuedetailsbyid(Model model, @PathVariable(required = false) String venueid){

        Optional oVenue = null;
        Venue venue = null;
        int venueCount = 0;
        boolean filterId = false;


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
        model.addAttribute("showFilters", filterId);
        return "venuedetailsbyid";
    }

}
