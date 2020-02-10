package br.com.versa.client.controller.business;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(int number) {
        this.numberStreet = number;
    }
}
