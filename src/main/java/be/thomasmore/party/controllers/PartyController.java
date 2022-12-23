package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Party;
import be.thomasmore.party.repositories.PartyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class PartyController {
    private Logger logger = LoggerFactory.getLogger(PartyController.class);

    @Autowired
    private PartyRepository partyRepository;

    @GetMapping("/partylist")
    public String partyList(Model model) {
        Iterable<Party> parties = partyRepository.findAll();
        model.addAttribute("parties", parties);
        return "partylist";
    }

    @GetMapping({"/partydetailsbyid", "/partydetailsbyid/{id}"})
    public String partyDetails(Model model,
                               @PathVariable(required = false) Integer id) {
        if (id == null) return "partydetailsbyid";

        /*Optional<Party> optionalParty = partyRepository.findById(id);
        if (optionalParty.isPresent()) {
            long nrOfPartys = partyRepository.count();
            model.addAttribute("party", optionalParty.get());
            model.addAttribute("prevId", id > 1 ? id - 1 : nrOfPartys);
            model.addAttribute("nextId", id < nrOfPartys ? id + 1 : 1);
        }
         */

        Optional oParty = null;
        Party party = null;
        int partyCount = 0;

        partyCount = (int) partyRepository.count();

        oParty = partyRepository.findById(Integer.parseInt(String.valueOf(id)));
        if(oParty.isPresent()){
            party = (Party) oParty.get();
        }

        int nextId = id + 1;
        if(nextId > partyCount){
            nextId = 1;
        }

        int prevId = id -1;
        if(prevId < 1){
            prevId =partyCount;
        }

        model.addAttribute("party", party);
        model.addAttribute("prevIndex", prevId);
        model.addAttribute("nextIndex", nextId);
        return "partydetailsbyid";
    }

    @GetMapping({"/partydetailsbyid/{id}/prev"})
    public String partydetailsPrev(Model model, @PathVariable int id) {
        Optional<Party> prevPartyFromDb = partyRepository.findFirstByIdLessThanOrderByIdDesc(id);
        if (prevPartyFromDb.isPresent())
            return String.format("redirect:/partydetailsbyid/%d", prevPartyFromDb.get().getId());
        Optional<Party> lastPartyFromDb = partyRepository.findFirstByOrderByIdDesc();
        if (lastPartyFromDb.isPresent())
            return String.format("redirect:/partydetailsbyid/%d", lastPartyFromDb.get().getId());
        return "partydetails";
    }

    @GetMapping({"/partydetailsbyid/{id}/next"})
    public String partydetailsNext(Model model, @PathVariable int id) {
        Optional<Party> nextPartyFromDb = partyRepository.findFirstByIdGreaterThanOrderByIdAsc(id);
        if (nextPartyFromDb.isPresent())
            return String.format("redirect:/partydetailsbyid/%d", nextPartyFromDb.get().getId());
        Optional<Party> firstPartyFromDb = partyRepository.findFirstByOrderByIdAsc();
        if (firstPartyFromDb.isPresent())
            return String.format("redirect:/partydetailsbyid/%d", firstPartyFromDb.get().getId());
        return "partydetails";
    }

}
