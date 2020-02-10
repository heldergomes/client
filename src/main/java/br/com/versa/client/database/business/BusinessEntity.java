package br.com.versa.client.database.business;

import br.com.versa.client.domain.business.Location;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Business")
public class BusinessEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBusiness;
    private String name;
    private String cnpj;

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
}
