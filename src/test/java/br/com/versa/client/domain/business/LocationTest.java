package br.com.versa.client.domain.business;

public class LocationTest {

    public static Location newLocation(){
        Location location = new Location();
        location.setState("São Paulo");
        location.setCity("Mogi das Cruzes");
        location.setNeighborhood("Ipiranga");
        location.setStreet("Avenida Alameda Marmoré");
        location.setNumberStreet(1001);
        return location;
    }
}
