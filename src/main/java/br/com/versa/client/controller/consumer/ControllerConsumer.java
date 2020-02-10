package br.com.versa.client.controller.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.RegisterConsumer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ControllerConsumer {

    private DtoMapperConsumer mapperConsumer;
    private RegisterConsumer registerConsumer;

    public ControllerConsumer(DtoMapperConsumer mapperConsumer, RegisterConsumer registerConsumer){
        this.mapperConsumer = mapperConsumer;
        this.registerConsumer = registerConsumer;
    }

    @RequestMapping(value = "/versa/client", method = RequestMethod.POST)
    public ResponseEntity<UUID> createNewConsumer(@Valid @RequestBody ConsumerDTO consumerDTO){
        Consumer consumer = mapperConsumer.toConsumer(consumerDTO);
        UUID idConsumer = registerConsumer.registerNewConsumer(consumer);
        return new ResponseEntity<>(idConsumer, HttpStatus.CREATED);
    }
}
