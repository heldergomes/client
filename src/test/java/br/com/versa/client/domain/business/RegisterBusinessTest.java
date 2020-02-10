package br.com.versa.client.domain.business;

import br.com.versa.client.domain.consumer.Consumer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RegisterBusinessTest {

    @Mock
    private Consumer consumer;
    @Mock
    private CreateNewBusiness createNewBusiness;

    @Test
    public void whenRegisterNewBusinessForConsumerThenNeedExecuteAllSteps(){
        MockitoAnnotations.initMocks(this);
        String idConsumer = String.valueOf(UUID.randomUUID());
        RegisterBusiness registerBusiness = new RegisterBusiness();


        verify(createNewBusiness, times(1)).createNewBusiness(any(Business.class));
    }
}
