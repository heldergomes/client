package br.com.versa.client.domain.entityutil;

import br.com.versa.client.domain.business.Location;

import java.util.UUID;

public class LocationUtil {

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
