package br.com.versa.client.domain.business;

import java.util.UUID;

public class Business {

    private UUID idBusiness;
    private String name;
    private String cnpj;
    private Location location;

    public UUID getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(UUID idBusiness) {
        this.idBusiness = idBusiness;
    }

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
