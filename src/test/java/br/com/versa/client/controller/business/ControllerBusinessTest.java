package br.com.versa.client.controller.business;

import br.com.versa.client.domain.business.BusinessTest;
import br.com.versa.client.domain.business.RegisterBusiness;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@DisplayName("Testing Controller Business")
class ControllerBusinessTest {

    @Mock
    private DtoMapperBusiness mapperBusiness;
    @Mock
    private RegisterBusiness registerBusiness;

    @DisplayName("When created one new Business then return an new Business created")
    @Test
    void WhenCreateNewBusinessThenReturnHttpStatusCreated(){
        MockitoAnnotations.initMocks(this);
        when(mapperBusiness.toBusiness(any(BusinessDTO.class))).thenReturn(BusinessTest.newBusinessWithoutIIUD());

        ControllerBusiness controller = new ControllerBusiness(mapperBusiness, registerBusiness);
        ResponseEntity response = controller.createBusiness(BusinessDTOTest.newBusinessDTORight(), UUID.randomUUID());

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @DisplayName("When try create one new business without id consumer then return exception")
    @Test
    void WhenTryCreatedOneBusinessWithoutIdConsumerThenReturnAnIdConsumerInvalidException(){
        ControllerBusiness controller = new ControllerBusiness(mapperBusiness, registerBusiness);

        Exception exception = assertThrows(
                IdConsumerInvalidException.class,
                () -> controller.createBusiness(BusinessDTOTest.newBusinessDTORight(), null)
        );
        assertEquals("Id consumer cannot be null", exception.getMessage());
    }
}
