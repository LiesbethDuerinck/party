package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Artist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends CrudRepository <Artist, Integer>{

    @Query("SELECT a FROM Artist a WHERE a.artistName like %:keyWord%")
    List<Artist> findByArtistNameLikeIgnoreCase(@Param("keyWord") String artistName);
}
