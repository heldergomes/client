package br.com.versa.client.domain.business;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private int numberStreet;

}
