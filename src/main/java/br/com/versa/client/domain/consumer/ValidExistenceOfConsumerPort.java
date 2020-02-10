package br.com.versa.client.domain.consumer;

import java.util.UUID;

public interface ValidExistenceOfConsumerPort {
    public void validConsumerAlreadyExist(UUID id);
}
