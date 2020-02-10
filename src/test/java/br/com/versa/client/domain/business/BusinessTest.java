package br.com.versa.client.domain.business;

public class BusinessTest {

    public static Business newBusinessWithoutIIUD(){
        Business business = new Business();
        business.setName("Versatti");
        business.setCnpj("44612388808006");
        business.setLocation(LocationTest.newLocation());
        return business;
    }
}
