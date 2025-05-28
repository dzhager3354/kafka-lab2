package ru.dzhager3354.apiService.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.dzhager3354.apiService.client.PlayerClient;
import ru.dzhager3354.apiService.dto.PlayerDto;
import ru.dzhager3354.apiService.entity.Player;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerService {
    private PlayerClient repository;

    public List<Player> getPlayers() {
        return repository.getPlayers();
    }
}
