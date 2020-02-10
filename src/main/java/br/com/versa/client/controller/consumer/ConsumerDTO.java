package br.com.versa.client.controller.consumer;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ConsumerDTO {

    @NotNull(message = "the first name do cannot null")
    private String firstName;
    @NotNull(message = "the last name do cannot null")
    private String lastName;
    @NotNull(message = "the login do cannot null")
    private String login;
    @NotNull(message = "the email do cannot null")
    @Email(message = "the email must be valid")
    private String email;
    @NotNull(message = "the password do cannot null")
    private String password;
    @NotNull(message = "the confirmPassword cannot be null")
    private String confirmPassword;

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
}
