package br.com.versa.client.domain.consumer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static br.com.versa.client.domain.entityutil.ConsumerUtil.newConsumerWithoutIIUDandDateTime;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@DisplayName("Testing Consumer")
public class ConsumerTest {

    @Mock
    private CreateNewConsumerPort createNewConsumerPort;

    @DisplayName("When register an new consumer then execute a new register new consumer")
    @Test
    void whenRegisterNewConsumerThenExecuteCreateNewConsumer(){
        MockitoAnnotations.initMocks(this);

        Consumer consumer = newConsumerWithoutIIUDandDateTime();
        consumer.setCreateNewConsumerPort(createNewConsumerPort);
        consumer.registerNewConsumer();

        verify(createNewConsumerPort, times(1)).createNewConsumer(any(Consumer.class));
    }

}
