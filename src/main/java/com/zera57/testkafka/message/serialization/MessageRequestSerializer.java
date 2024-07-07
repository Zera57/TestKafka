package com.zera57.testkafka.message.serialization;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zera57.testkafka.message.MessageRequest;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
public class MessageRequestSerializer implements Serializer<MessageRequest> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String s, MessageRequest messageRequest) {
        try {
            if (messageRequest == null){
                System.out.println("Null received at serializing");
                return null;
            }
            return objectMapper.writeValueAsBytes(messageRequest);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing MessageDto to byte[]");
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
