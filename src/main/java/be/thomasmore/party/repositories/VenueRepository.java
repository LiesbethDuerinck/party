package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface VenueRepository extends CrudRepository <Venue, Integer> {
    Iterable<Venue> findByParking(boolean parking);

    Iterable<Venue> findByFoodAvailable(boolean foodAvailable);

    Iterable<Venue> findByKidsFriendly(boolean kidsFriendly);

    //Iterable<Venue> findByCapacityBetween(Integer min, Integer max);

    @Query("SELECT v FROM Venue v WHERE v.capacity between ?1 and ?2")
    List<Venue> findByCapacityBetweenQuery(int min, int max);
}



