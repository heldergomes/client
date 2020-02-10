package br.com.versa.client.domain.consumer.exception;

public class InvalidConfirmPasswordException extends RuntimeException {
    public InvalidConfirmPasswordException(String message) {
        super(message);
    }
}
