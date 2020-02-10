package br.com.versa.client.controller.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ConsumerTest;
import br.com.versa.client.domain.consumer.RegisterConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Testing Controller Consumer")
class ControllerConsumerTest {

    @Mock
    private DtoMapperConsumer mapperConsumer;
    @Mock
    private RegisterConsumer registerConsumer;

    @DisplayName("When created new consumer then return an consumer created")
    @Test
    void WhenCreateNewConsumerThenReturnHttpStatusCreated(){
        MockitoAnnotations.initMocks(this);
        when(mapperConsumer.toConsumer(any(ConsumerDTO.class))).thenReturn(ConsumerTest.newConsumerWithoutIIUD());
        when(registerConsumer.registerNewConsumer(any(Consumer.class))).thenReturn(UUID.randomUUID());

        ControllerConsumer controller = new ControllerConsumer(mapperConsumer, registerConsumer);
        ResponseEntity response = controller.createNewConsumer(ConsumerDTOTest.newConsumerDTORight());

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @DisplayName("When created new consumer then return an Id consumer")
    @Test
    void WhenCreateNewConsumerThenReturnConsumerIIUD(){
        MockitoAnnotations.initMocks(this);
        UUID newConsumerIIUD = UUID.randomUUID();
        when(mapperConsumer.toConsumer(any(ConsumerDTO.class))).thenReturn(ConsumerTest.newConsumerWithoutIIUD());
        when(registerConsumer.registerNewConsumer(any(Consumer.class))).thenReturn(newConsumerIIUD);

        ControllerConsumer controller = new ControllerConsumer(mapperConsumer, registerConsumer);
        ResponseEntity response = controller.createNewConsumer(ConsumerDTOTest.newConsumerDTORight());

        assertEquals(response.getBody(), newConsumerIIUD);
    }

}
