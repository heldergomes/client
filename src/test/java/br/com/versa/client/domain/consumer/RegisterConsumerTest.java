package br.com.versa.client.domain.consumer;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RegisterConsumerTest {

    @Mock
    private CreateNewConsumer createNewConsumer;
    @Mock
    private Consumer consumer;

    @Test
    public void whenRegisterNewConsumerThenReturnIdConsumer(){
        MockitoAnnotations.initMocks(this);
        UUID idConsumer = UUID.randomUUID();
        when(createNewConsumer.createNewConsumer(any(Consumer.class))).thenReturn(idConsumer);

        RegisterConsumer registerConsumer = new RegisterConsumer(createNewConsumer);
        UUID expectedIdConsumer = registerConsumer.registerNewConsumer(consumer);

        assertEquals(idConsumer, expectedIdConsumer);
    }
}
