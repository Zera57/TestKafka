package com.zera57.testkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Svyatoslav Avtonomov (zera57)
 */
@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic zeraTopic() {
        return TopicBuilder.name("zera").build();
    }
}
