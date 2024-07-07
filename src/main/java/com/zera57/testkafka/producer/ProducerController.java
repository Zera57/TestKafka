package com.zera57.testkafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
@RestController
@RequestMapping("api/v1/producer")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/message")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        kafkaTemplate.send("zera", messageRequest.message());
    }
}
