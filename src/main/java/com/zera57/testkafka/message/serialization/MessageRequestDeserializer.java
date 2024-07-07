package com.zera57.testkafka.message.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zera57.testkafka.message.MessageRequest;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
public class MessageRequestDeserializer implements Deserializer<MessageRequest> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MessageRequest deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            return objectMapper.readValue(new String(data, "UTF-8"), MessageRequest.class);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to MessageDto");
        }
    }

}
