package br.com.versa.client.controller.consumer;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
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

}
