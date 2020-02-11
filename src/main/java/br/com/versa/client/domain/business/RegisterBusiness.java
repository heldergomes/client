package br.com.versa.client.domain.business;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegisterBusiness {

    private CreateNewBusinessPort createNewBusinessPort;
    private ValidExistenceOfConsumerPort validExistenceOfConsumerPort;

    public RegisterBusiness(CreateNewBusinessPort createNewBusinessPort, ValidExistenceOfConsumerPort validExistenceOfConsumerPort){
        this.createNewBusinessPort = createNewBusinessPort;
        this.validExistenceOfConsumerPort = validExistenceOfConsumerPort;
    }

    public void registerBusinessForConsumer(Business business, UUID idConsumer){
        Consumer consumer = new Consumer(validExistenceOfConsumerPort);
        consumer.setIdConsumer(idConsumer);
        consumer.validExistenceOfConsumer();
        createNewBusinessPort.createNewBusiness(business, consumer.getIdConsumer());
    }
}
