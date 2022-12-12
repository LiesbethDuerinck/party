package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArtistRepository extends CrudRepository <Artist, Integer>{

    @Query("SELECT a FROM Artist a WHERE a.artistName = :artistName")
    List<Artist> findByArtistName(String artistName);
}
