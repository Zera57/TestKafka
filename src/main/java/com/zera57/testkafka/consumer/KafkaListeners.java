package com.zera57.testkafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
@Component
public class KafkaListeners {

    @KafkaListener(topics = "zera", groupId = "testListener")
    void listener(String message) {
        System.out.println("Listener received: " + message);
    }
}
