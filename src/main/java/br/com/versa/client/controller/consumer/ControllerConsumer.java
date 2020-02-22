package br.com.versa.client.controller.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.CreateNewConsumerPort;
import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ControllerConsumer {

    private DtoMapperConsumer mapperConsumer;
    private CreateNewConsumerPort createNewConsumerPort;

    public ControllerConsumer(DtoMapperConsumer mapperConsumer,
                              CreateNewConsumerPort createNewConsumerPort){
        this.mapperConsumer = mapperConsumer;
        this.createNewConsumerPort = createNewConsumerPort;
    }

    @RequestMapping(value = "/versa/client", method = RequestMethod.POST)
    public ResponseEntity<UUID> createNewConsumer(@Valid @RequestBody ConsumerDTO consumerDTO){
        Consumer consumer = mapperConsumer.toConsumer(consumerDTO);
        consumer.setCreateNewConsumerPort(createNewConsumerPort);
        consumer.registerNewConsumer();
        return new ResponseEntity<>(consumer.getIdConsumer(), HttpStatus.CREATED);
    }
}
