package br.com.versa.client.domain.consumer;

import br.com.versa.client.domain.consumer.exception.InvalidConfirmPasswordException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Consumer {

    private UUID idConsumer;
    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;
    private String confirmPassword;
    private LocalDateTime dateTimeCreatedConsumer;

    private ValidExistenceOfConsumerPort validExistenceOfConsumerPort;
    private CreateNewConsumerPort createNewConsumerPort;


    public void validExistenceOfConsumer(UUID idConsumer){
        validExistenceOfConsumerPort.validConsumerAlreadyExist(idConsumer);
    }

    public UUID registerNewConsumer(){
        isRightPassword();
        setIdConsumer(UUID.randomUUID());
        setDateTimeCreatedConsumer(LocalDateTime.now());
        createNewConsumerPort.createNewConsumer(this);
        return getIdConsumer();
    }

    private void isRightPassword(){
        if (!getConfirmPassword().equals(getPassword()))
            throw new InvalidConfirmPasswordException("The confirmPassword is different to password");
    }
}
