package br.com.versa.client.controller.consumer;


public class ConsumerDTOTest {

    public static ConsumerDTO newConsumerDTORight(){
        ConsumerDTO dto = new ConsumerDTO();
        dto.setFirstName("Helder");
        dto.setLastName("Ardachnikoff");
        dto.setLogin("tomate");
        dto.setEmail("tomate@gmail.com");
        dto.setPassword("abc1234");
        dto.setConfirmPassword("abc1234");
        return dto;
    }
}
