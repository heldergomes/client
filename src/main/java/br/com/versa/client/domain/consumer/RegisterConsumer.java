package br.com.versa.client.domain.consumer;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegisterConsumer {

    private CreateNewConsumerPort createNewConsumerPort;

    public RegisterConsumer(CreateNewConsumerPort createNewConsumerPort){
        this.createNewConsumerPort = createNewConsumerPort;
    }

    public UUID registerNewConsumer(Consumer consumer){
        consumer.isRightPassword();
        consumer.generateDateTimeCreateConsumer();

        return createNewConsumerPort.createNewConsumer(consumer);
    }
}
