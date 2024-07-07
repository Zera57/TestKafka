package com.zera57.testkafka.producer.config;

import java.util.HashMap;
import java.util.Map;

import com.zera57.testkafka.message.MessageRequest;
import com.zera57.testkafka.message.serialization.MessageRequestSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    public Map<String, Object> getProducerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, MessageRequestSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, MessageRequest> producerFactory() {
        return new DefaultKafkaProducerFactory<>(getProducerConfigs());
    }

    @Bean
    public KafkaTemplate<String, MessageRequest> kafkaTemplate(
            ProducerFactory<String, MessageRequest> producerFactory
    ) {
        return new KafkaTemplate<>(producerFactory);
    }
}
