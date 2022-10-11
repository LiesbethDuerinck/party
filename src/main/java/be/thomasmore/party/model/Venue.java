package be.thomasmore.party.model;

public class Venue {
    private String venueName;
    private String linkMoreInfo;
    private String city;
    private boolean KidsFriendly;
    private boolean foodAvailable;
    private boolean parking;

    public Venue(){}

    public Venue(String venueName, String linkMoreInfo, String city, boolean KidsFriendly, boolean foodAvailable, boolean parking){
        this.venueName = venueName;
        this.linkMoreInfo = linkMoreInfo;
        this.city = city;
        this.KidsFriendly = KidsFriendly;
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
        return KidsFriendly;
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
        KidsFriendly = kidsFriendly;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }
}
