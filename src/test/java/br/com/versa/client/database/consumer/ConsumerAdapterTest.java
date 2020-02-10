package br.com.versa.client.database.consumer;

import br.com.versa.client.domain.consumer.Consumer;
import br.com.versa.client.domain.consumer.ConsumerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

}
