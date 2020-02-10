package br.com.versa.client.database.business.location;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Location")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID IdLocation;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private int numberStreet;

    public UUID getIdLocation() {
        return IdLocation;
    }

    public void setIdLocation(UUID idLocation) {
        IdLocation = idLocation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(int numberStreet) {
        this.numberStreet = numberStreet;
    }
}
