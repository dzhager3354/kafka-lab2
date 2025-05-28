package ru.dzhager3354.apiService.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import ru.dzhager3354.apiService.client.PlayerDataClient;
import ru.dzhager3354.apiService.dto.PlayerDataDto;
import ru.dzhager3354.apiService.dto.PlayerDataPlaytimeDto;
import ru.dzhager3354.apiService.dto.PlayerPlaytimeDto;
import ru.dzhager3354.apiService.entity.PlayerData;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PlayerDataService {
    private PlayerDataClient repository;

    public Long getPlaytimeByServer(String server) {
        return repository.getPlaytimeByServer(server);
    }

    public List<PlayerPlaytimeDto> getGlobalPlaytime() {
        return repository.getGlobalPlaytime();
    }

    public List<PlayerPlaytimeDto> getTopPlaytimeByServer(String server) {
        return repository.getTopPlaytimeByServer(server);
    }
}
