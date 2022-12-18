package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VenueRepository extends CrudRepository <Venue, Integer> {
    @Query("select v from Venue v where v.parking")
    List<Venue> findByParking(boolean hasParking);

    @Query("select v from Venue v where v.foodAvailable")
    List<Venue> findByFoodAvailable(boolean foodAvailable);

    @Query("select v from Venue v where v.kidsFriendly")
    List<Venue> findByKidsFriendly(boolean isKidsFriendly);

    @Query("SELECT v FROM Venue v WHERE v.capacity between ?1 and ?2")
    List<Venue> findByCapacityBetweenQuery(int min, int max);

}



