package br.com.versa.client.domain.consumer;

import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsumerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void WhenPasswordIsDifferentToConfirmPasswordThenReturnInvalidConfirmPasswordException(){
        thrown.expect(InvalidConfirmPasswordException.class);
        thrown.expectMessage("The confirmPassword is different to password");
        Consumer consumer = newConsumerWithDifferentPassword();
        consumer.isRightPassword();
    }

    @Test
    public void WhenGenerateDateTimeCreateConsumerThenDateTimeCreatedConsumerShouldNotNull(){
        Consumer consumer = newConsumerWithoutIIUDandDateTime();
        consumer.generateDateTimeCreateConsumer();
        assertNotNull(consumer.getDateTimeCreatedConsumer());
    }

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
