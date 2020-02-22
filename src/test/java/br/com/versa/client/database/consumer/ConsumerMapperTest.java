package br.com.versa.client.database.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ConsumerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static br.com.versa.client.domain.entityutil.ConsumerUtil.newConsumerWithoutIIUD;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Consumer Mapper")
class ConsumerMapperTest {

    @DisplayName("When Mapper some consumer to Entity then return new entity")
    @Test
    void WhenMapperConsumerToConsumerEntityThenReturnNewConsumerEntity(){
        ConsumerMapper mapper = new ConsumerMapper();
        Consumer consumer = newConsumerWithoutIIUD();
        ConsumerEntity consumerEntity = mapper.toConsumerEntity(consumer);

        assertAll("consumerEntity",
            () -> assertEquals(consumer.getFirstName(), consumerEntity.getFirstName()),
            () -> assertEquals(consumer.getLastName(), consumerEntity.getLastName()),
            () -> assertEquals(consumer.getLogin(), consumerEntity.getLogin()),
            () -> assertEquals(consumer.getEmail(), consumerEntity.getEmail()),
            () -> assertEquals(consumer.getPassword(), consumerEntity.getPassword()),
            () -> assertEquals(consumer.getDateTimeCreatedConsumer(), consumerEntity.getDateTimeCreatedConsumer())
        );
    }
}
