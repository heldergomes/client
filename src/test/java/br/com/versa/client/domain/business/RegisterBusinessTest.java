package br.com.versa.client.domain.business;

import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayName("Testing Register Business Usecase")
class RegisterBusinessTest {

    @Mock
    private CreateNewBusinessPort createNewBusinessPort;
    @Mock
    private ValidExistenceOfConsumerPort validExistenceOfConsumerPort;

    @DisplayName("When register an new Business then need execute all steps")
    @Test
    void whenRegisterNewBusinessForConsumerThenNeedExecuteAllSteps(){
        MockitoAnnotations.initMocks(this);
        UUID idConsumer = UUID.randomUUID();
        Business business = BusinessTest.newBusinessWithoutIIUD();
        RegisterBusiness registerBusiness = new RegisterBusiness(createNewBusinessPort, validExistenceOfConsumerPort);
        registerBusiness.registerBusinessForConsumer(business, idConsumer);

        verify(createNewBusinessPort, times(1)).createNewBusiness(any(Business.class));
    }
}
