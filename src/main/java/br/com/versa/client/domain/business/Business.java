package br.com.versa.client.domain.business;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Business {

    private UUID idBusiness;
    private String name;
    private String cnpj;
    private Location location;

}
