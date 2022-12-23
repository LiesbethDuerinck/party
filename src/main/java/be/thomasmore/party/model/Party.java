package be.thomasmore.party.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
public class Party {
    @Id
    private Integer id;
    private String name;
    private Integer pricePresaleInEur;
    private Integer priceInEur;
    private String extraInfo;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date doors;
    @ManyToOne(fetch = FetchType.LAZY)
    private Venue venue;
    @ManyToMany
    Collection<Artist> artists;

    public Party(){}

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Date getDoors() {
        return doors;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPriceInEur() {
        return priceInEur;
    }

    public Integer getPricePresaleInEur() {
        return pricePresaleInEur;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDoors(Date doors) {
        this.doors = doors;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriceInEur(Integer priceInEur) {
        this.priceInEur = priceInEur;
    }

    public void setPricePresaleInEur(Integer pricePresaleInEur) {
        this.pricePresaleInEur = pricePresaleInEur;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Collection<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Collection<Artist> artists) {
        this.artists = artists;
    }
}
