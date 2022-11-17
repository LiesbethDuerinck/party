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

import java.util.Optional;

@Controller
public class ArtistController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/artistlist")
    public String artistlist(Model model){
        Iterable<Artist> artists = artistRepository.findAll();
        model.addAttribute("artists", artists);
        return "artistlist";
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


}
