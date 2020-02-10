package br.com.versa.client.database.consumer.exception;

public class ConsumerNonexistentException extends RuntimeException {
    public ConsumerNonexistentException(String message) {
        super(message);
    }
}
