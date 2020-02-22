package br.com.versa.client.database.consumer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "Consumer")
public class ConsumerEntity {

    @Id
    private UUID idConsumer;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private LocalDateTime dateTimeCreatedConsumer;

}
