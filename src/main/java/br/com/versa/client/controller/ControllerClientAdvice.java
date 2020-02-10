package br.com.versa.client.controller;

import br.com.versa.client.controller.business.InvalidIdConsumerException;
import br.com.versa.client.database.consumer.exception.ConsumerNonexistentException;
import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerClientAdvice {

    private static String BAD_REQUEST = "400";
    private static String NOT_FOUND = "404";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidConfirmPasswordException.class)
    public ResponseErrorDTO invalidPassword(InvalidConfirmPasswordException exception){
        ResponseErrorDTO error = new ResponseErrorDTO();
        error.setReturnCode(BAD_REQUEST);
        error.setMessage(exception.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidIdConsumerException.class)
    public ResponseErrorDTO invalidIdConsumer(InvalidIdConsumerException exception){
        ResponseErrorDTO error = new ResponseErrorDTO();
        error.setReturnCode(BAD_REQUEST);
        error.setMessage(exception.getMessage());
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ConsumerNonexistentException.class)
    public ResponseErrorDTO invalidConsumer(ConsumerNonexistentException exception){
        ResponseErrorDTO error = new ResponseErrorDTO();
        error.setReturnCode(NOT_FOUND);
        error.setMessage(exception.getMessage());
        return error;
    }
}
