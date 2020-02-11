package br.com.versa.client.database.business.location;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Location")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID IdLocation;
    private UUID idBusiness;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private int numberStreet;

}
