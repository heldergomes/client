package br.com.versa.client.controller.business;

public class InvalidIdConsumerException extends RuntimeException {
    public InvalidIdConsumerException(String message) {
        super(message);
    }
}
