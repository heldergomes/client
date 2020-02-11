package br.com.versa.client.database.consumer;

import br.com.versa.client.database.consumer.exception.ConsumerNonexistentException;
import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ConsumerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Testing Consumer Adapter")
class ConsumerAdapterTest {

    @Mock
    private ConsumerMapper mapper;
    @Mock
    private ConsumerRepository repository;

    @DisplayName("When persist one new Consumer then return one Id Consumer")
    @Test
    void WhenCreateNewConsumerThenReturnUUIDConsumer(){
        MockitoAnnotations.initMocks(this);
        ConsumerEntity consumerEntity = ConsumerEntityTest.newConsumerEntity();
        when(mapper.toConsumerEntity(any(Consumer.class))).thenReturn(consumerEntity);
        when(repository.save(any(ConsumerEntity.class))).thenReturn(consumerEntity);

        ConsumerAdapter adapter = new ConsumerAdapter(mapper, repository);
        UUID idConsumer = adapter.createNewConsumer(ConsumerTest.newConsumerWithoutIIUD());

        assertEquals(idConsumer, consumerEntity.getIdConsumer());
    }

    @DisplayName("When Consumer don't exist then return an Exception")
    @Test
    void whenConsumerNotExistThenReturnException(){
        MockitoAnnotations.initMocks(this);
        when(repository.findById(any(UUID.class))).thenReturn(Optional.empty());
        ConsumerAdapter adapter = new ConsumerAdapter(mapper, repository);
        Exception exception = assertThrows(ConsumerNonexistentException.class,
                () -> adapter.validConsumerAlreadyExist(UUID.randomUUID()));
        assertEquals("Its necessary to have a consumer to create a new business", exception.getMessage());
    }

    @DisplayName("When Consumer exist then don't execute exception")
    @Test
    void whenConsumerExistThenNotExecuteException(){
        MockitoAnnotations.initMocks(this);
        ConsumerEntity consumerEntity = new ConsumerEntity();
        consumerEntity.setIdConsumer(UUID.randomUUID());
        Optional<ConsumerEntity> consumerOptional = Optional.of(consumerEntity);
        when(repository.findById(any(UUID.class))).thenReturn(consumerOptional);
        ConsumerAdapter adapter = new ConsumerAdapter(mapper, repository);
        assertDoesNotThrow(() -> adapter.validConsumerAlreadyExist(UUID.randomUUID()));
    }
}
