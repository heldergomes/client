package br.com.versa.client.controller;

import br.com.versa.client.controller.business.IdConsumerInvalidException;
import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerClientAdvice {

    private static String BAD_REQUEST = "400";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidConfirmPasswordException.class)
    public ResponseErrorDTO invalidPassword(InvalidConfirmPasswordException exception){
        ResponseErrorDTO error = new ResponseErrorDTO();
        error.setReturnCode(BAD_REQUEST);
        error.setMessage(exception.getMessage());
        error.setTraceElements(exception.getStackTrace());
        return error;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IdConsumerInvalidException.class)
    public ResponseErrorDTO invalidIdConsumer(IdConsumerInvalidException exception){
        ResponseErrorDTO error = new ResponseErrorDTO();
        error.setReturnCode(BAD_REQUEST);
        error.setMessage(exception.getMessage());
        error.setTraceElements(exception.getStackTrace());
        return error;
    }
}
