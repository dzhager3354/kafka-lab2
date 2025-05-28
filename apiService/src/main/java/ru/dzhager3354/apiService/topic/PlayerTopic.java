package ru.dzhager3354.apiService.topic;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.dzhager3354.apiService.dto.PlayerDto;

import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerTopic {
    private KafkaTemplate<String, PlayerDto> kafkaTemplate;

    public void createPlayer(PlayerDto dto) {
        kafkaTemplate.send(MessageBuilder.withPayload(dto)
                .setHeader(KafkaHeaders.KEY, UUID.randomUUID().toString())
                .setHeader(KafkaHeaders.TOPIC, "players")
                .build()
        );
    }
}
