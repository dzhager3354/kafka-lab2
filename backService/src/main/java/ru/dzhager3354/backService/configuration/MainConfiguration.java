package ru.dzhager3354.backService.configuration;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.dzhager3354.backService.dto.PlayerDataDto;
import ru.dzhager3354.backService.dto.PlayerDataPlaytimeDto;
import ru.dzhager3354.backService.dto.PlayerDto;
import ru.dzhager3354.backService.dto.PlayerPlaytimeDto;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class MainConfiguration {
    private Map<String, Object> get() {
        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "name");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
        return config;
    }

    @Bean
    public ConsumerFactory<String, PlayerDto> playerConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(get(), new StringDeserializer(), new JsonDeserializer<>(PlayerDto.class));//.ignoreTypeHeaders());
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlayerDto> playerListener() {
        ConcurrentKafkaListenerContainerFactory<String, PlayerDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(playerConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, PlayerDataDto> playerDataDtoConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(get(), new StringDeserializer(), new JsonDeserializer<>(PlayerDataDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlayerDataDto> playerDataListener() {
        ConcurrentKafkaListenerContainerFactory<String, PlayerDataDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(playerDataDtoConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, PlayerDataPlaytimeDto> playerPlaytimeConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(get(), new StringDeserializer(), new JsonDeserializer<>(PlayerDataPlaytimeDto.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PlayerDataPlaytimeDto> playerPlaytimeListener() {
        ConcurrentKafkaListenerContainerFactory<String, PlayerDataPlaytimeDto> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(playerPlaytimeConsumerFactory());
        return factory;
    }
}
