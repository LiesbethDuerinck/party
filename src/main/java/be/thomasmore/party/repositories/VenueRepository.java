package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Venue;
import org.springframework.data.repository.CrudRepository;


public interface VenueRepository extends CrudRepository <Venue, Integer> {
    Iterable<Venue> findByParking(boolean parking);

    Iterable<Venue> findByFoodAvailable(boolean foodAvailable);
}