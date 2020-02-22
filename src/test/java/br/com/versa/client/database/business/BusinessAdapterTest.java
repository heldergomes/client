package br.com.versa.client.database.business;

import br.com.versa.client.database.business.location.LocationEntity;
import br.com.versa.client.database.business.location.LocationEntityTest;
import br.com.versa.client.database.business.location.LocationRepository;
import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.entityutil.BusinessUtil;
import br.com.versa.client.domain.business.CreateNewBusinessPort;
import br.com.versa.client.domain.business.Location;
import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static br.com.versa.client.domain.entityutil.BusinessUtil.newBusiness;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@DisplayName("Testing Business Adapter")
public class BusinessAdapterTest {

    @Mock
    private BusinessRepository repositoryBusiness;
    @Mock
    private LocationRepository repositoryLocation;
    @Mock
    private BusinessMapper mapper;
    @Mock
    private CreateNewBusinessPort createNewBusinessPort;
    @Mock
    private ValidExistenceOfConsumerPort ValidExistenceOfConsumerPort;

    @DisplayName("When create new business then execute all steps")
    @Test
    void whenCreateNewBusinessThenExecuteAllSteps(){
        MockitoAnnotations.initMocks(this);
        Business business = newBusiness();
        when(mapper.toBusinessEntity(any(Business.class), any(UUID.class))).thenReturn(BusinessEntityTest.newBusinessEntity());
        when(mapper.toLocationEntity(any(Location.class), any(UUID.class))).thenReturn(LocationEntityTest.newLocationEntity());
        BusinessAdapter adapter = new BusinessAdapter(repositoryBusiness, repositoryLocation, mapper);
        adapter.createNewBusiness(business, UUID.randomUUID());

        verify(mapper, times(1)).toBusinessEntity(any(Business.class), any(UUID.class));
        verify(mapper, times(1)).toLocationEntity(any(Location.class), any(UUID.class));
        verify(repositoryBusiness, times(1)).save(any(BusinessEntity.class));
        verify(repositoryLocation, times(1)).save(any(LocationEntity.class));
    }
}
