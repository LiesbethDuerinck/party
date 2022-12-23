package be.thomasmore.party.model;

import org.springframework.data.annotation.Id;

import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.Collection;

public class Animal {
    @Id
    private int id;
    private String name;
    private String city;
    private String bio;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Party> parties;

    public Animal(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Party> getParties() {
        return parties;
    }

    public String getBio() {
        return bio;
    }

    public String getCity() {
        return city;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setParties(Collection<Party> parties) {
        this.parties = parties;
    }

}
