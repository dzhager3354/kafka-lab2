package ru.dzhager3354.apiService.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic playersTopic() {
        return TopicBuilder.name("players").build();
    }

    @Bean
    public NewTopic playerDataTopic() {
        return TopicBuilder.name("playerdata").build();
    }

    @Bean
    public NewTopic playerDataUpdateTopic() {
        return TopicBuilder.name("playerdata-update").build();
    }
}
