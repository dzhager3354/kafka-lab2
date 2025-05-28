package ru.dzhager3354.apiService.topic;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.dzhager3354.apiService.dto.PlayerDataDto;
import ru.dzhager3354.apiService.dto.PlayerDataPlaytimeDto;
import ru.dzhager3354.apiService.entity.PlayerData;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerDataTopic {
    private KafkaTemplate<String, PlayerData> kafkaTemplate;

    public void create(PlayerDataDto dto) {
        kafkaTemplate.send(MessageBuilder.withPayload(dto)
                .setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.TOPIC, "playerdata").build());
    }

    public void updatePlaytime(PlayerDataPlaytimeDto dto) {
        kafkaTemplate.send(MessageBuilder.withPayload(dto)
                .setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.TOPIC, "playerdata-update").build());
    }
}
