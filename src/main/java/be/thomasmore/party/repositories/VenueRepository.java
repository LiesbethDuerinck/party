package be.thomasmore.party.repositories;

import be.thomasmore.party.model.Venue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface VenueRepository extends CrudRepository<Venue, Integer> {

    @Query("SELECT v FROM Venue v WHERE " +
            "(:minCapacity IS NULL OR :minCapacity <= v.capacity) AND " +
            "(:maxCapacity IS NULL OR v.capacity <= :maxCapacity) AND " +
            "(:foodAvailable IS NULL OR v.foodAvailable = :foodAvailable) AND " +
            "(:parking IS NULL OR v.parking=:parking) AND " +
            "(:kidsFriendly IS NULL OR v.kidsFriendly=:kidsFriendly) ")
    List<Venue> findByFilter(@Param("minCapacity") Integer minCapacity,
                             @Param("maxCapacity") Integer maxCapacity,
                             @Param("foodAvailable") Boolean filterFood,
                             @Param("parking") Boolean filterParking,
                             @Param("kidsFriendly") Boolean filterKids);

    /*@Query("SELECT v FROM Venue v WHERE v.capacity between ?1 and ?2")
    List<Venue> findByCapacityBetweenQuery(int min, int max);
*/
}



