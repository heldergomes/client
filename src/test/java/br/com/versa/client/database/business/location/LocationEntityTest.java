package br.com.versa.client.database.business.location;

import java.util.UUID;

public class LocationEntityTest {

    public static LocationEntity newLocationEntity(){
        LocationEntity entity = new LocationEntity();
        entity.setIdLocation(UUID.randomUUID());
        entity.setState("São Paulo");
        entity.setCity("Mogi das Cruzes");
        entity.setNeighborhood("Alto do Ipiranga");
        entity.setStreet("Avenida João Mateus");
        entity.setNumberStreet(16);
        return entity;
    }
}
