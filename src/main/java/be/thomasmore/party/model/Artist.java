package be.thomasmore.party.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Artist {
    @Id
    private int id;
    private String artistName;
    private String linkMoreInfo;
    private String genre;
    @Column(length=1000)
    private String bio;
    private String portfolio;

    public Artist(){}

    public Artist(int id, String artistName, String linkMoreInfo, String genre, String bio, String portfolio){
        this.id = id;
        this.artistName = artistName;
        this.linkMoreInfo = linkMoreInfo;
        this.genre = genre;
        this.bio = bio;
        this.portfolio = portfolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLinkMoreInfo(String linkMoreInfo) {
        this.linkMoreInfo = linkMoreInfo;
    }

    public String getLinkMoreInfo() {
        return linkMoreInfo;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getBio() {
        return bio;
    }

    public String getGenre() {
        return genre;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }
}
