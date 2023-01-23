package com.ran.kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ran.kafka.producer.model.Address;
import com.ran.kafka.producer.model.Customer;
import com.ran.kafka.producer.model.LineItem;
import com.ran.kafka.producer.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper mapper;

    public void sendMessage(Order message){
        message = getOrder();
        try {
            LOGGER.info(String.format("Message sent -> %s", mapper.writeValueAsString(message)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        kafkaTemplate.send("quickstart-events", message.toString());
    }

    public Order getOrder() {
        return Order.builder()
                .orderId(101)
                .itemList(Collections.singletonList(LineItem.builder().productId(50001).productName("Laptop Charger").price(15).qauntity(2).build()))
                .customer(Customer.builder().custId(7777).name("Ranjan P").address(Address.builder().street("8817 Rodeo Drive").aptNumber("329").city("Irving").state("TX").zipCode(75063).build()).build()).build();
    }
}