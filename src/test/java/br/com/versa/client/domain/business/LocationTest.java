package br.com.versa.client.domain.business;

import java.util.UUID;

public class LocationTest {

    public static Location newLocationWithoutUUID(){
        Location location = new Location();
        location.setState("São Paulo");
        location.setCity("Mogi das Cruzes");
        location.setNeighborhood("Ipiranga");
        location.setStreet("Avenida Alameda Marmoré");
        location.setNumberStreet(1001);
        return location;
    }

    public static Location newLocation(){
       Location location = newLocationWithoutUUID();
       location.setIdLocation(UUID.randomUUID());
       return location;
    }
}
