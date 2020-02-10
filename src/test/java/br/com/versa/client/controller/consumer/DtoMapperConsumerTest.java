package br.com.versa.client.controller.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ConsumerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Consumer Mapper")
class DtoMapperConsumerTest {

    @DisplayName("When Converter one DTO to Consumer then return one Consumer Entity")
    @Test
    void whenConverterDtoToConsumerThenReturnConsumer(){
        DtoMapperConsumer mapper = new DtoMapperConsumer();
        Consumer consumer = mapper.toConsumer(ConsumerDTOTest.newConsumerDTORight());
        Consumer expectConsumer = ConsumerTest.newConsumerWithoutIIUDandDateTime();

        assertAll("expectedConsumer",
            () -> assertEquals(expectConsumer.getIdConsumer(), consumer.getIdConsumer()),
            () -> assertEquals(expectConsumer.getFirstName(), consumer.getFirstName()),
            () -> assertEquals(expectConsumer.getLastName(), consumer.getLastName()),
            () -> assertEquals(expectConsumer.getLogin(), consumer.getLogin()),
            () -> assertEquals(expectConsumer.getEmail(), consumer.getEmail()),
            () -> assertEquals(expectConsumer.getPassword(), consumer.getPassword()),
            () -> assertEquals(expectConsumer.getConfirmPassword(), consumer.getConfirmPassword()),
            () -> assertEquals(expectConsumer.getDateTimeCreatedConsumer(), consumer.getDateTimeCreatedConsumer())
        );

    }
}
