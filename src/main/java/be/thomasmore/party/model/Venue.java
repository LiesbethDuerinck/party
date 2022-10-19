package be.thomasmore.party.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Venue {
    @Id
    private String id;

    private String venueName;
    private String linkMoreInfo;

    private String city;
    private boolean kidsFriendly;
    private boolean foodAvailable;
    private boolean parking;

    public Venue(){}

    public Venue(String venueName, String linkMoreInfo, String city, boolean kidsFriendly, boolean foodAvailable, boolean parking){

        this.venueName = venueName;
        this.linkMoreInfo = linkMoreInfo;
        this.city = city;
        this.kidsFriendly = kidsFriendly;
        this.foodAvailable = foodAvailable;
        this.parking = parking;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getLinkMoreInfo() {
        return linkMoreInfo;
    }

    public void setLinkMoreInfo(String linkMoreInfo) {
        this.linkMoreInfo = linkMoreInfo;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getCity() {
        return city;
    }

    public boolean isFoodAvailable() {
        return foodAvailable;
    }

    public boolean isKidsFriendly() {
        return kidsFriendly;
    }

    public boolean isParking() {
        return parking;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setFoodAvailable(boolean foodAvailable) {
        this.foodAvailable = foodAvailable;
    }

    public void setKidsFriendly(boolean kidsFriendly) {
        kidsFriendly = kidsFriendly;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }
}
