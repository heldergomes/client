package br.com.versa.client.database.business;

import br.com.versa.client.database.business.location.LocationEntity;
import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.BusinessTest;
import br.com.versa.client.domain.business.Location;
import br.com.versa.client.domain.business.LocationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Business Mapper")
public class BusinessMapperTest {

    @DisplayName("When Mapper some Business to Entity then return new entity")
    @Test
    void WhenMapperBusinessToBusinessEntityThenReturnNewBusinessEntity(){
        BusinessMapper mapper = new BusinessMapper();
        UUID idConsumer = UUID.randomUUID();
        Business business = BusinessTest.newBusiness();
        BusinessEntity businessEntity = mapper.toBusinessEntity(business, idConsumer);

        assertAll("businessEntity",
            () -> assertEquals(business.getIdBusiness(), businessEntity.getIdBusiness()),
            () -> assertEquals(idConsumer, businessEntity.getIdConsumer()),
            () -> assertEquals(business.getCnpj(), businessEntity.getCnpj()),
            () -> assertEquals(business.getName(), businessEntity.getName())
        );
    }

    @DisplayName("When Mapper some Location to Entity then return new entity")
    @Test
    void WhenMapperLocationToLocationEntityThenReturnNewLocationEntity(){
        BusinessMapper mapper = new BusinessMapper();
        UUID idBusiness = UUID.randomUUID();
        Location location = LocationTest.newLocation();
        LocationEntity locationEntity = mapper.toLocationEntity(location,idBusiness);

        assertAll("locationEntity",
            () -> assertEquals(location.getIdLocation(), locationEntity.getIdLocation()),
            () -> assertEquals(idBusiness, locationEntity.getIdBusiness()),
            () -> assertEquals(location.getState(), locationEntity.getState()),
            () -> assertEquals(location.getCity(), locationEntity.getCity()),
            () -> assertEquals(location.getNeighborhood(), locationEntity.getNeighborhood()),
            () -> assertEquals(location.getStreet(), locationEntity.getStreet()),
            () -> assertEquals(location.getNumberStreet(), locationEntity.getNumberStreet())
        );
    }
}
