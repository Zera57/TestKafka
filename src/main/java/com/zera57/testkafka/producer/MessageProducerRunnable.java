package com.zera57.testkafka.producer;

import com.zera57.testkafka.message.MessageRequest;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
public class MessageProducerRunnable implements Runnable {
    private int taskId;
    private KafkaTemplate<String, MessageRequest> kafkaTemplate;
    private MessageRequest messageRequest;

    public MessageProducerRunnable(
            int id,
            KafkaTemplate<String, MessageRequest> kafkaTemplate,
            MessageRequest messageRequest) {
        this.taskId = id;
        this.kafkaTemplate = kafkaTemplate;
        this.messageRequest = messageRequest;
    }

    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
        for (int i = 0; i < 100000; i++) {
//            try {
//                Thread.sleep(1000 * taskId);
                MessageRequest messageRequestToSend =
                        new MessageRequest(
                                messageRequest.id(),
                                "{taskId " + taskId + " " + i + "} {" + messageRequest.message() + "}",
                                messageRequest.color());
                kafkaTemplate.send("zera", "keyTest", messageRequestToSend);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        }
    }
}
