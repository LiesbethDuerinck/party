package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class VenueController {

    private final Logger logger = LoggerFactory.getLogger(VenueController.class);

    @Autowired
    private VenueRepository venueRepository;


    @GetMapping({"/venuelist/filter"})
    public String venueListWithFilter(Model model,
                                      @RequestParam(required = false) Integer minCapacity,
                                      @RequestParam(required = false) Integer maxCapacity,
                                      @RequestParam(required = false) Boolean filterFood,
                                      @RequestParam(required = false) Boolean filterParking,
                                      @RequestParam(required = false) Boolean filterKids) {
        logger.info(String.format("venueListWithFilter -- min=%d, max=%d, filterFood=%s, filterParking=%s, , filterKids=%s",
                minCapacity, maxCapacity, filterFood, filterParking, filterKids));

        List<Venue> venues = null;

        if (minCapacity == null && maxCapacity == null && filterFood == null && filterParking == null && filterKids == null) {
            venues = (List<Venue>) venueRepository.findAll();
        }else{
           venues = venueRepository.findByFilter(minCapacity, maxCapacity,
                    filterFood, filterParking, filterKids);
        }

        int counter = 0;
        for(Object i : venues) counter++;

        model.addAttribute("venues", venues);
        model.addAttribute("showFilters", true);
        model.addAttribute("minCapacity", minCapacity);
        model.addAttribute("maxCapacity", maxCapacity);
        model.addAttribute("filterFood", filterFood);
        model.addAttribute("filterParking", filterParking);
        model.addAttribute("filterKids", filterKids);
        model.addAttribute("total", counter);

        return "venuelist";
    }

    private Boolean filterStringToBoolean(String filterString) {
        return (filterString == null || filterString.equals("all")) ? null : filterString.equals("yes");
    }


    @GetMapping("/venuelist")
    public String venuelist (Model model){
        Iterable<Venue> venues = venueRepository.findAll();
        model.addAttribute("venues",venues);
        return "venuelist";
    }

    @GetMapping({"/venuedetailsbyid","/venuedetailsbyid/","/venuedetailsbyid/{venueid}"})
    public String venuedetailsbyid(Model model,
                                   @PathVariable(required = false) String venueid){

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
