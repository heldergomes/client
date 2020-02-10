package br.com.versa.client.database.consumer;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Consumer")
public class ConsumerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idConsumer;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private LocalDateTime dateTimeCreatedConsumer;

    public UUID getIdConsumer() {
        return idConsumer;
    }

    public void setIdConsumer(UUID idConsumer) {
        this.idConsumer = idConsumer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getDateTimeCreatedConsumer() {
        return dateTimeCreatedConsumer;
    }

    public void setDateTimeCreatedConsumer(LocalDateTime dateTimeCreatedConsumer) {
        this.dateTimeCreatedConsumer = dateTimeCreatedConsumer;
    }
}
