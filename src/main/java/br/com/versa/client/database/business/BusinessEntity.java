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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idBusiness;
    private String name;
    private String cnpj;

}
