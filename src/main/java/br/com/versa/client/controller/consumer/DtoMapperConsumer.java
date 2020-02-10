package br.com.versa.client.controller.consumer;

import br.com.versa.client.config.MapperConfig;
import br.com.versa.client.domain.consumer.Consumer;
import org.springframework.stereotype.Service;

@Service
public class DtoMapperConsumer {

    public Consumer toConsumer(ConsumerDTO dto){
        return MapperConfig.generate().map(dto, Consumer.class);
    }

}
