package br.com.versa.client.domain.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ValidConsumer {

    @Autowired
    private ValidConsumerExist validConsumerExist;

    public void validConsumerExist(UUID id){
        validConsumerExist.validConsumerAlreadyExist(id);
    }
}
