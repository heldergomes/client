package br.com.versa.client.database.business;

import br.com.versa.client.database.business.location.LocationEntity;
import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.Location;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BusinessMapper {

    private ModelMapper mapper = new ModelMapper();

    public BusinessEntity toBusinessEntity(Business business, UUID idConsumer) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        BusinessEntity businessEntity = mapper.map(business, BusinessEntity.class);
        businessEntity.setIdConsumer(idConsumer);
        return businessEntity;
    }

    public LocationEntity toLocationEntity(Location location, UUID idBusiness) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        LocationEntity locationEntity = mapper.map(location, LocationEntity.class);
        locationEntity.setIdBusiness(idBusiness);
        return locationEntity;
    }
}
