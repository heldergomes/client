package br.com.versa.client.database.business;

import br.com.versa.client.database.business.location.LocationEntity;
import br.com.versa.client.database.business.location.LocationRepository;
import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.CreateNewBusinessPort;
import br.com.versa.client.domain.business.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BusinessAdapter implements CreateNewBusinessPort {

    private BusinessRepository repositoryBusiness;
    private LocationRepository repositoryLocation;
    private BusinessMapper mapper;

    public BusinessAdapter (BusinessRepository repositoryBusiness, LocationRepository repositoryLocation, BusinessMapper mapper){
        this.mapper = mapper;
        this.repositoryBusiness = repositoryBusiness;
        this.repositoryLocation = repositoryLocation;
    }
    @Override
    public void createNewBusiness(Business business, UUID idConsumer) {
        BusinessEntity entity = mapper.toBusinessEntity(business, idConsumer);
        repositoryBusiness.save(entity);
        insertBusinessLocation(business.getLocation(), business.getIdBusiness());
    }

    private void insertBusinessLocation(Location location, UUID idBusiness){
        LocationEntity entity = mapper.toLocationEntity(location, idBusiness);
        repositoryLocation.save(entity);
    }

}
