package com.zera57.testkafka.message.serialization;

import com.zera57.testkafka.message.MessageColor;
import com.zera57.testkafka.message.MessageRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
class MessageRequestSerializerTest {
    private final MessageRequestSerializer serializer = new MessageRequestSerializer();
    private final MessageRequestDeserializer deserializer = new MessageRequestDeserializer();

    @Test
    public void testSerializeAndDeserialize() {
        MessageRequest messageRequest = new MessageRequest(
                123L,
                "Message",
                MessageColor.RED
        );
        byte[] actual = serializer.serialize("topic", messageRequest);
        MessageRequest deserialized = deserializer.deserialize("topic", actual);
        assertEquals(messageRequest, deserialized);
    }
}