package br.com.versa.client.controller.business;

import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.CreateNewBusinessPort;
import br.com.versa.client.domain.consumer.ValidExistenceOfConsumerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ControllerBusiness {

    private DtoMapperBusiness mapperBusiness;
    private CreateNewBusinessPort createNewBusinessPort;
    private ValidExistenceOfConsumerPort validExistenceOfConsumerPort;

    public ControllerBusiness(DtoMapperBusiness mapperBusiness,
                              CreateNewBusinessPort createNewBusinessPort,
                              ValidExistenceOfConsumerPort validExistenceOfConsumerPort){
        this.mapperBusiness = mapperBusiness;
        this.createNewBusinessPort = createNewBusinessPort;
        this.validExistenceOfConsumerPort = validExistenceOfConsumerPort;
    }

    @RequestMapping(value = "/versa/client/{id}", method = RequestMethod.POST)
    public ResponseEntity createBusiness(@Valid @RequestBody BusinessDTO businessDTO, @PathVariable("id") UUID idConsumer){
        validIdConsumer(idConsumer);
        Business business = mapperBusiness.toBusiness(businessDTO);

        business.setCreateNewBusinessPort(createNewBusinessPort);
        business.setValidExistenceOfConsumerPort(validExistenceOfConsumerPort);
        business.registerBusinessForConsumer(idConsumer);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private void validIdConsumer(UUID idConsumer){
        if(idConsumer == null)
            throw new InvalidIdConsumerException("Id consumer cannot be null");
    }
}
