package com.ran.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

    @Autowired
    private KafkaProducerService service;

    private int count;

    @PostMapping("/produce")
    public String produceMessage(@RequestBody String message) {
        String test = "Spring boot kafka producer message : "+count++ +" : " +message;
        service.sendMessage(test);
        return test;
    }
}
