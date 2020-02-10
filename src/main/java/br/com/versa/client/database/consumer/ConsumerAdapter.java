package br.com.versa.client.database.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.CreateNewConsumer;
import br.com.versa.client.domain.consumer.ValidConsumerExist;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsumerAdapter implements CreateNewConsumer, ValidConsumerExist {

    private ConsumerMapper mapper;
    private ConsumerRepository repository;

    public ConsumerAdapter(ConsumerMapper mapper, ConsumerRepository repository){
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public UUID createNewConsumer(Consumer consumer) {
        ConsumerEntity consumerEntity = mapper.toConsumerEntity(consumer);
        ConsumerEntity consumerInserted = repository.save(consumerEntity);
        return consumerInserted.getIdConsumer();
    }

    @Override
    public void validConsumerAlreadyExist(UUID id) {
        repository.findById(id);
    }

}
