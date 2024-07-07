package com.zera57.testkafka.producer;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
public class MessageProducerRunnable implements Runnable {
    private int taskId;

    public MessageProducerRunnable(int id) {
        this.taskId = id;
    }

    @Override
    public void run() {
        System.out.println("Task ID : " + this.taskId + " performed by " + Thread.currentThread().getName());
    }
}
