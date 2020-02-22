package br.com.versa.client.domain.business;

import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static br.com.versa.client.domain.entityutil.BusinessUtil.newBusinessWithoutIIUD;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;


@DisplayName("Testing Business Entity")
class BusinessTest {

    @Mock
    CreateNewBusinessPort createNewBusinessPort;

    @Mock
    ValidExistenceOfConsumerPort validExistenceOfConsumerPort;

    @Test
    void whenRegisterNewBusinessThenExecuteAllSteps(){
        MockitoAnnotations.initMocks(this);
        Business business = newBusinessWithoutIIUD();
        business.setCreateNewBusinessPort(createNewBusinessPort);
        business.setValidExistenceOfConsumerPort(validExistenceOfConsumerPort);
        business.registerBusinessForConsumer(UUID.randomUUID());

        verify(validExistenceOfConsumerPort, times(1)).validConsumerAlreadyExist(any(UUID.class));
        verify(createNewBusinessPort, times(1)).createNewBusiness(any(Business.class), any(UUID.class));
    }

}
