package br.com.versa.client.controller.business;

import br.com.versa.client.domain.business.Business;
import br.com.versa.client.domain.business.RegisterBusiness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class ControllerBusiness {

    private DtoMapperBusiness mapperBusiness;
    private  RegisterBusiness registerBusiness;

    public ControllerBusiness(DtoMapperBusiness mapperBusiness, RegisterBusiness registerBusiness){
        this.mapperBusiness = mapperBusiness;
        this.registerBusiness = registerBusiness;
    }

    @RequestMapping(value = "/versa/client/{id}", method = RequestMethod.POST)
    public ResponseEntity createBusiness(@Valid @RequestBody BusinessDTO businessDTO, @PathVariable("id") UUID idConsumer){
        validIdConsumer(idConsumer);
        Business business = mapperBusiness.toBusiness(businessDTO);
        registerBusiness.registerBusinessForConsumer(business, idConsumer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private void validIdConsumer(UUID idConsumer){
        if(idConsumer == null)
            throw new IdConsumerInvalidException("Id consumer cannot be null");
    }
}
