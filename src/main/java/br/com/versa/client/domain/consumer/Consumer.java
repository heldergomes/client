package br.com.versa.client.domain.consumer;

import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Consumer {

    private UUID idConsumer;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private String confirmPassword;
    private LocalDateTime dateTimeCreatedConsumer;


    public void isRightPassword(){
        if (!getConfirmPassword().equals(getPassword()))
            throw new InvalidConfirmPasswordException("The confirmPassword is different to password");
    }

    public void generateDateTimeCreateConsumer(){
        setDateTimeCreatedConsumer(LocalDateTime.now());
    }

    public UUID getIdConsumer() {
        return idConsumer;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public LocalDateTime getDateTimeCreatedConsumer() {
        return dateTimeCreatedConsumer;
    }

    public void setIdConsumer(UUID idConsumer) {
        this.idConsumer = idConsumer;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setDateTimeCreatedConsumer(LocalDateTime dateTimeCreatedConsumer) {
        this.dateTimeCreatedConsumer = dateTimeCreatedConsumer;
    }
}
