package br.com.versa.client.controller;

import br.com.versa.client.controller.business.InvalidIdConsumerException;
import br.com.versa.client.database.consumer.exception.ConsumerNonexistentException;
import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Testing Controller Client Advice")
class ControllerClientAdviceTest {


    @DisplayName("When invalid password then return an exception")
    @Test
    void whenInvalidPasswordThenReturnException(){
        InvalidConfirmPasswordException exception = new InvalidConfirmPasswordException("The confirmPassword is different to password");
        ControllerClientAdvice advice = new ControllerClientAdvice();
        ResponseErrorDTO response = advice.invalidPassword(exception);

        assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), response.getReturnCode());
        assertEquals(exception.getMessage(), response.getMessage());
    }

    @DisplayName("When invalid id consumer then return an exception")
    @Test
    void whenInvalidIdConsumerThenReturnException(){
        InvalidIdConsumerException exception = new InvalidIdConsumerException("Id consumer cannot be null");
        ControllerClientAdvice advice = new ControllerClientAdvice();
        ResponseErrorDTO response = advice.invalidIdConsumer(exception);

        assertEquals(String.valueOf(HttpStatus.BAD_REQUEST.value()), response.getReturnCode());
        assertEquals(exception.getMessage(), response.getMessage());
    }

    @DisplayName("When consumer don't exist then return an exception")
    @Test
    void whenInvalidConsumerThenReturnException(){
        ConsumerNonexistentException exception = new ConsumerNonexistentException("Its necessary to have a consumer to create a new business");
        ControllerClientAdvice advice = new ControllerClientAdvice();
        ResponseErrorDTO response = advice.invalidConsumer(exception);

        assertEquals(String.valueOf(HttpStatus.NOT_FOUND.value()), response.getReturnCode());
        assertEquals(exception.getMessage(), response.getMessage());
    }
}
