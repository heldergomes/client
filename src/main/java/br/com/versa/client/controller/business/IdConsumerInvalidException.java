package br.com.versa.client.controller.business;

public class IdConsumerInvalidException extends RuntimeException {
    public IdConsumerInvalidException(String message) {
        super(message);
    }
}
