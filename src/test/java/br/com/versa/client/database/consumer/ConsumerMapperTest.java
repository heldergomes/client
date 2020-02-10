package br.com.versa.client.database.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ConsumerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Consumer Mapper")
public class ConsumerMapperTest {

    @DisplayName("")
    @Test
    public void WhenMapperConsumerToConsumerEntityThenReturnNewConsumerEntity(){
        ConsumerMapper mapper = new ConsumerMapper();
        Consumer consumer = ConsumerTest.newConsumerWithoutIIUD();
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
