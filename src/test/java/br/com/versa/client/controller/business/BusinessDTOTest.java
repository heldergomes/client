package br.com.versa.client.controller.business;

public class BusinessDTOTest {

    public static BusinessDTO newBusinessDTORight(){
        BusinessDTO dto = new BusinessDTO();
        dto.setName("Versatti");
        dto.setCnpj("44612388808006");
        dto.setState("São Paulo");
        dto.setCity("Mogi das Cruzes");
        dto.setNeighborhood("Ipiranga");
        dto.setStreet("Avenida Alameda Marmoré");
        dto.setNumberStreet(1001);
        return dto;
    }
}
