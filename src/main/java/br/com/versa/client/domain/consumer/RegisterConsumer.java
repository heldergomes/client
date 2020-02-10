package br.com.versa.client.domain.consumer;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegisterConsumer {

    private CreateNewConsumer createNewConsumer;

    public RegisterConsumer(CreateNewConsumer createNewConsumer){
        this.createNewConsumer = createNewConsumer;
    }

    public UUID registerNewConsumer(Consumer consumer){
        consumer.isRightPassword();
        consumer.generateDateTimeCreateConsumer();

        return createNewConsumer.createNewConsumer(consumer);
    }
}
