package br.com.versa.client.database.consumer;

import br.com.versa.client.database.consumer.exception.ConsumerNonexistentException;
import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.CreateNewConsumerPort;
import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumerAdapter implements CreateNewConsumerPort, ValidExistenceOfConsumerPort {

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
        Optional<ConsumerEntity> consumerEntity = repository.findById(id);
        if (consumerEntity.equals(Optional.empty()))
            throw new ConsumerNonexistentException("Its necessary to have a consumer to create a new business");
    }

}
