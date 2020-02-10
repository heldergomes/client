package br.com.versa.client.controller.business;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class BusinessDTO {

    @NotNull(message = "the name of business cannot be null")
    private String name;
    @NotNull(message = "the cnpj of business cannot be null")
    @Size(min = 14, max = 14, message = "the lenght of cnpj must be 14 digits")
    private String cnpj;
    @NotNull(message = "the state of business cannot be null")
    private String state;
    @NotNull(message = "the city of business cannot be null")
    private String city;
    @NotNull(message = "the neighborhood of business cannot be null")
    private String neighborhood;
    @NotNull(message = "the street of business do cannot null")
    private String street;
    @NotNull(message = "the number of business do cannot null")
    private int numberStreet;

}
