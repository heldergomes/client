package br.com.versa.client.domain.business;

import br.com.versa.client.domain.consumer.ValidConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegisterBusiness {

    @Autowired
    private ValidConsumer validConsumer;
    @Autowired
    private CreateNewBusiness createNewBusiness;

    public void registerBusinessForConsumer(Business business, UUID idConsumer){

        validConsumer.validConsumerExist(idConsumer);
        createNewBusiness.createNewBusiness(business);


    }
}
