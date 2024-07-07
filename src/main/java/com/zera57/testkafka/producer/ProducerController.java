package com.zera57.testkafka.producer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.zera57.testkafka.message.MessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
@RestController
@RequestMapping("api/v1/producer")
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, MessageRequest> kafkaTemplate;



    @PostMapping("/message")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        ExecutorService executorService = Executors.newFixedThreadPool(5); // Pool of 5 threads

        for (int i = 0; i < 10; i++) {
            Runnable worker = new MessageProducerRunnable(i, kafkaTemplate, messageRequest);
            executorService.execute(worker);
        }

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        System.out.println("Finished all threads");
    }
}
