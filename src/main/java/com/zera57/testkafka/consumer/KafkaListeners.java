package com.zera57.testkafka.consumer;

import com.zera57.testkafka.message.MessageRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
@Component
public class KafkaListeners {

    @KafkaListener(topics = "zera", groupId = "testListener")
    void listener(MessageRequest message) {
        System.out.println("Listener received: " + message);
    }
}
