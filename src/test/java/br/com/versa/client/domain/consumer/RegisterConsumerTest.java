package br.com.versa.client.domain.consumer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Testing Register Consumer Usecase")
class RegisterConsumerTest {

    @Mock
    private CreateNewConsumerPort createNewConsumerPort;
    @Mock
    private Consumer consumer;

    @DisplayName("When register an new consumer then return your Id")
    @Test
    void whenRegisterNewConsumerThenReturnIdConsumer(){
        MockitoAnnotations.initMocks(this);
        UUID idConsumer = UUID.randomUUID();
        when(createNewConsumerPort.createNewConsumer(any(Consumer.class))).thenReturn(idConsumer);

        RegisterConsumer registerConsumer = new RegisterConsumer(createNewConsumerPort);
        UUID expectedIdConsumer = registerConsumer.registerNewConsumer(consumer);

        assertEquals(idConsumer, expectedIdConsumer);
    }
}
