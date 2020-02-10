package br.com.versa.client.controller.business;

import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.BusinessTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Business Mapper")
class DtoMapperBusinessTest {

    @DisplayName("When Converter one DTO to Business then return one Business Entity")
    @Test
    void whenConverterDtoToBusinessThenReturnBusiness(){
        DtoMapperBusiness mapper = new DtoMapperBusiness();
        Business business = mapper.toBusiness(BusinessDTOTest.newBusinessDTORight());
        Business expectBusiness = BusinessTest.newBusinessWithoutIIUD();

        assertAll("expectBusiness",
            () -> assertEquals(expectBusiness.getName(), business.getName()),
            () -> assertEquals(expectBusiness.getCnpj(), business.getCnpj()),
            () -> assertEquals(expectBusiness.getLocation().getState(), business.getLocation().getState()),
            () -> assertEquals(expectBusiness.getLocation().getCity(), business.getLocation().getCity()),
            () -> assertEquals(expectBusiness.getLocation().getNeighborhood(), business.getLocation().getNeighborhood()),
            () -> assertEquals(expectBusiness.getLocation().getStreet(), business.getLocation().getStreet()),
            () -> assertEquals(expectBusiness.getLocation().getNumberStreet(), business.getLocation().getNumberStreet())
        );
    }
}
