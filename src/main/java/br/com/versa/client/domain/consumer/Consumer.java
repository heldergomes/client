package br.com.versa.client.domain.consumer;

import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Consumer {

    private ValidExistenceOfConsumerPort validExistenceOfConsumerPort;
    public Consumer(ValidExistenceOfConsumerPort validExistenceOfConsumerPort){
        this.validExistenceOfConsumerPort = validExistenceOfConsumerPort;
    }

    private UUID idConsumer;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private String confirmPassword;
    private LocalDateTime dateTimeCreatedConsumer;


    public void isRightPassword(){
        if (!getConfirmPassword().equals(getPassword()))
            throw new InvalidConfirmPasswordException("The confirmPassword is different to password");
    }

    public void generateDateTimeCreateConsumer(){
        setDateTimeCreatedConsumer(LocalDateTime.now());
    }

    public void validExistenceOfConsumer(){
        validExistenceOfConsumerPort.validConsumerAlreadyExist(this.idConsumer);
    }
}
