package br.com.versa.client.controller.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.CreateNewConsumerPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static br.com.versa.client.domain.entityutil.ConsumerUtil.newConsumerWithoutIIUD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("Testing Controller Consumer")
class ControllerConsumerTest {

    @Mock
    private DtoMapperConsumer mapperConsumer;
    @Mock
    private CreateNewConsumerPort createNewConsumerPort;

    @DisplayName("When created new consumer then return an consumer created")
    @Test
    void WhenCreateNewConsumerThenReturnHttpStatusCreated(){
        MockitoAnnotations.initMocks(this);
        when(mapperConsumer.toConsumer(any(ConsumerDTO.class))).thenReturn(newConsumerWithoutIIUD());

        ControllerConsumer controller = new ControllerConsumer(mapperConsumer, createNewConsumerPort);
        ResponseEntity response = controller.createNewConsumer(ConsumerDTOTest.newConsumerDTORight());

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
    }

    @DisplayName("When created new consumer then verify all methods")
    @Test
    void WhenCreateNewConsumerThenVerifyAllMethods(){
        MockitoAnnotations.initMocks(this);
        when(mapperConsumer.toConsumer(any(ConsumerDTO.class))).thenReturn(newConsumerWithoutIIUD());

        ControllerConsumer controller = new ControllerConsumer(mapperConsumer, createNewConsumerPort);
        ResponseEntity response = controller.createNewConsumer(ConsumerDTOTest.newConsumerDTORight());

        verify(mapperConsumer, times(1)).toConsumer(any(ConsumerDTO.class));
        verify(createNewConsumerPort, times(1)).createNewConsumer(any(Consumer.class));
    }

}
