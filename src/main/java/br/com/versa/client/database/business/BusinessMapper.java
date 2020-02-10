package br.com.versa.client.database.business;

import br.com.versa.client.database.business.location.LocationEntity;
import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.Location;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class BusinessMapper {

    private ModelMapper mapper = new ModelMapper();

    public BusinessEntity toBusinessEntity(Business business) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper.map(business, BusinessEntity.class);
    }

    public LocationEntity toLocationEntity(Location location) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper.map(location, LocationEntity.class);
    }
}
