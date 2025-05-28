package ru.dzhager3354.backService.topic;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.dzhager3354.backService.dto.PlayerDto;
import ru.dzhager3354.backService.repository.CustomPlayerRepository;

@Service
@AllArgsConstructor
public class PlayerTopic {
    private CustomPlayerRepository playerRepository;

    @KafkaListener(topics = "players", groupId = "listener", containerFactory = "playerListener")
    public void createPlayer(PlayerDto dto) {
        System.out.println(dto);
        playerRepository.create(dto);
    }
}
