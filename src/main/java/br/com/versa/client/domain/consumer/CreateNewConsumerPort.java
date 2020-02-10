package br.com.versa.client.domain.consumer;

import java.util.UUID;

public interface CreateNewConsumerPort {
    public UUID createNewConsumer(Consumer consumer);
}
