package br.com.versa.client.database.business;

import java.util.UUID;

public class BusinessEntityTest {

    public static BusinessEntity newBusinessEntity(){
        BusinessEntity entity = new BusinessEntity();
        entity.setIdBusiness(UUID.randomUUID());
        entity.setCnpj("12364777897756");
        entity.setName("Versatti Comunicacao Visual");
        return entity;
    }
}
