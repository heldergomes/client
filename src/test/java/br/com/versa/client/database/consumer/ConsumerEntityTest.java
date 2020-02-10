package br.com.versa.client.database.consumer;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.UUID;

public class ConsumerEntityTest {

    public static ConsumerEntity newConsumerEntity(){
        ConsumerEntity consumer = new ConsumerEntity();
        consumer.setIdConsumer(UUID.randomUUID());
        consumer.setFirstName("Helder");
        consumer.setLastName("Ardachnikoff");
        consumer.setLogin("tomate");
        consumer.setEmail("tomate@gmail.com");
        consumer.setPassword("abc1234");
        consumer.setDateTimeCreatedConsumer(LocalDateTime.of(2019, Month.APRIL,12,12,20));
        return consumer;
    }
}
