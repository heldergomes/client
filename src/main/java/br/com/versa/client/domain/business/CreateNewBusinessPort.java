package br.com.versa.client.domain.business;

import java.util.UUID;

public interface CreateNewBusinessPort {
    public void createNewBusiness(Business business, UUID idConsumer);
}
