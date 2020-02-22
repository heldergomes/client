package br.com.versa.client.domain.entityutil;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;

public class ConsumerUtil {

    public static Consumer newConsumerWithDifferentPassword(){
        Consumer consumer = new Consumer();
        consumer.setFirstName("Helder");
        consumer.setLastName("Ardachnikoff");
        consumer.setLogin("tomate");
        consumer.setEmail("tomate@gmail.com");
        consumer.setPassword("abc1234");
        consumer.setConfirmPassword("abc4321");
        consumer.setDateTimeCreatedConsumer(LocalDateTime.of(2019, Month.APRIL,12,12,20));
        return consumer;
    }

    public static Consumer newConsumerWithoutIIUD(){
        Consumer consumer = new Consumer();
        consumer.setFirstName("Helder");
        consumer.setLastName("Ardachnikoff");
        consumer.setLogin("tomate");
        consumer.setEmail("tomate@gmail.com");
        consumer.setPassword("abc1234");
        consumer.setConfirmPassword("abc1234");
        consumer.setDateTimeCreatedConsumer(LocalDateTime.of(2019, Month.APRIL,12,12,20));
        return consumer;
    }

    public static Consumer newConsumerWithoutIIUDandDateTime(){
        Consumer consumer = new Consumer();
        consumer.setFirstName("Helder");
        consumer.setLastName("Ardachnikoff");
        consumer.setLogin("tomate");
        consumer.setEmail("tomate@gmail.com");
        consumer.setPassword("abc1234");
        consumer.setConfirmPassword("abc1234");
        return consumer;
    }
}
