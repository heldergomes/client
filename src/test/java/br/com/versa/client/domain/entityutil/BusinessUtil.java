package br.com.versa.client.domain.entityutil;

import br.com.versa.client.domain.business.Business;

import java.util.UUID;

public class BusinessUtil {

    public static Business newBusinessWithoutIIUD(){
        Business business = new Business();
        business.setName("Versatti");
        business.setCnpj("44612388808006");
        business.setLocation(LocationUtil.newLocationWithoutUUID());
        return business;
    }

    public static Business newBusiness(){
        Business business = newBusinessWithoutIIUD();
        business.setIdBusiness(UUID.randomUUID());
        business.setLocation(LocationUtil.newLocation());
        return business;
    }
}
