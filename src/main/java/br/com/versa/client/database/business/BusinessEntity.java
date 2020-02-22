package br.com.versa.client.database.business;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Business")
public class BusinessEntity {

    @Id
    private UUID idBusiness;
    private UUID idConsumer;
    private String name;
    private String cnpj;

}
