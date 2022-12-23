package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Party;
import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.PartyRepository;
import be.thomasmore.party.repositories.VenueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Controller
@RequestMapping({"/admin"})
public class AdminController {

    private final Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private PartyRepository partyRepository;

    @Autowired
    private VenueRepository venueRepository;

    @ModelAttribute("party")
    public Party findParty(@PathVariable(required = false) Integer id) {
        logger.info("findParty " + id);
        if (id == null) return new Party();

        Optional<Party> optionalParty = partyRepository.findById(id);
        //noinspection OptionalIsPresent
        if (optionalParty.isPresent())
            return optionalParty.get();
        return null;
    }

    @GetMapping("/partyedit/{id}")
    public String partyEdit(Model model,
                            @PathVariable int id) {
        logger.info("partyEdit " + id);
        model.addAttribute("venues", venueRepository.findAll());
        return "admin/partyedit";
    }

    @PostMapping({"/partyedit/{id}"})
    public String partyEditPost(Model model, @PathVariable int id,
                                @RequestParam String name,
                                @RequestParam Integer priceInEur,
                                @RequestParam Integer presale,
                                @RequestParam String extraInfo) {
        logger.info("partyEditPost " + id + " -- new name=" + name + ", new priceInEur=" + priceInEur + ", new presale=" + presale + ", new extraInfo=" + extraInfo) ;
        Optional<Party> optionalParty = partyRepository.findById(id);
        if (optionalParty.isPresent()){
            Party party = optionalParty.get();
            party.setName(name);
            party.setPriceInEur(priceInEur);
            party.setPricePresaleInEur(presale);
            party.setExtraInfo(extraInfo);
            partyRepository.save(party);
            model.addAttribute("party", party);
        }
        return "redirect:/partyedit/" + id;
    }
/*
    @GetMapping("/partynew")
    public String partyNew(Model model) {
        logger.info("partyNew ");
        model.addAttribute("party", new Party());
        model.addAttribute("venues", venueRepository.findAll());
        return "admin/partynew";
    }

    /*
    @PostMapping("/partynew")
    public String partyNewPost(Model model,
                               @ModelAttribute("party") Party party,
                               @RequestParam int venueId) {
        logger.info("partyNewPost -- new name=" + party.getName() + ", date=" + party.getDate());
        party.setVenue(new Venue(venueId));
        Party newParty = partyRepository.save(party);
        return "redirect:/partydetails/" + newParty.getId();
    }

*/

}
