package br.com.versa.client.database.consumer;

import br.com.versa.client.config.MapperConfig;
import br.com.versa.client.domain.consumer.Consumer;
import org.springframework.stereotype.Service;

@Service
public class ConsumerMapper {

    public ConsumerEntity toConsumerEntity(Consumer consumer){
        return MapperConfig.generate().map(consumer, ConsumerEntity.class);
    }

}
