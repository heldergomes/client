package br.com.versa.client.domain.consumer;

import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Consumer")
public class ConsumerTest {

    @Autowired
    private static ValidExistenceOfConsumerPort validExistenceOfConsumerPort;

    @DisplayName("When password of cosumer is diferent to confirm password then return exception")
    @Test
    void WhenPasswordIsDifferentToConfirmPasswordThenReturnInvalidConfirmPasswordException(){
        Consumer consumer = newConsumerWithDifferentPassword();
        Exception exception = assertThrows(InvalidConfirmPasswordException.class,
                () -> consumer.isRightPassword());
        assertEquals("The confirmPassword is different to password", exception.getMessage());
    }

    @DisplayName("When generate a cunsumer's date-time then return something not null")
    @Test
    void WhenGenerateDateTimeCreateConsumerThenDateTimeCreatedConsumerShouldNotNull(){
        Consumer consumer = newConsumerWithoutIIUDandDateTime();
        consumer.generateDateTimeCreateConsumer();
        assertNotNull(consumer.getDateTimeCreatedConsumer());
    }

    public static Consumer newConsumerWithDifferentPassword(){
        Consumer consumer = new Consumer(validExistenceOfConsumerPort);
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
        Consumer consumer = new Consumer(validExistenceOfConsumerPort);
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
        Consumer consumer = new Consumer(validExistenceOfConsumerPort);
        consumer.setFirstName("Helder");
        consumer.setLastName("Ardachnikoff");
        consumer.setLogin("tomate");
        consumer.setEmail("tomate@gmail.com");
        consumer.setPassword("abc1234");
        consumer.setConfirmPassword("abc1234");
        return consumer;
    }

}
