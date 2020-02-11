package br.com.versa.client.domain.business;

import java.util.UUID;

public class BusinessTest {

    public static Business newBusinessWithoutIIUD(){
        Business business = new Business();
        business.setName("Versatti");
        business.setCnpj("44612388808006");
        business.setLocation(LocationTest.newLocationWithoutUUID());
        return business;
    }

    public static Business newBusiness(){
        Business business = newBusinessWithoutIIUD();
        business.setIdBusiness(UUID.randomUUID());
        business.setLocation(LocationTest.newLocation());
        return business;
    }
}
