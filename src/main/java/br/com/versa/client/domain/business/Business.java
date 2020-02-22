package br.com.versa.client.domain.business;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Business {

    private UUID idBusiness;
    private String name;
    private String cnpj;
    private Location location;

    private CreateNewBusinessPort createNewBusinessPort;
    private ValidExistenceOfConsumerPort validExistenceOfConsumerPort;


    public void registerBusinessForConsumer(UUID idConsumer){
        Consumer consumer = new Consumer();
        consumer.setValidExistenceOfConsumerPort(validExistenceOfConsumerPort);
        consumer.validExistenceOfConsumer(idConsumer);
        setIdBusiness(UUID.randomUUID());
        location.setIdLocation(UUID.randomUUID());
        createNewBusinessPort.createNewBusiness(this, idConsumer);
    }

}
