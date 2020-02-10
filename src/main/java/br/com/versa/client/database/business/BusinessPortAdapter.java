package br.com.versa.client.database.business;

import br.com.versa.client.database.business.location.LocationEntity;
import br.com.versa.client.database.business.location.LocationRepository;
import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.CreateNewBusinessPort;
import br.com.versa.client.domain.business.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessPortAdapter implements CreateNewBusinessPort {

    @Autowired
    private BusinessRepository repositoryBusiness;
    @Autowired
    private LocationRepository repositoryLocation;
    @Autowired
    private BusinessMapper mapper;

    @Override
    public void createNewBusiness(Business business) {
        BusinessEntity entity = mapper.toBusinessEntity(business);
        repositoryBusiness.save(entity);
        insertBusinessLocation(business.getLocation());
    }

    private void insertBusinessLocation(Location location){
        LocationEntity entity = mapper.toLocationEntity(location);
        repositoryLocation.save(entity);
    }

}
