package ru.dzhager3354.backService.topic;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.dzhager3354.backService.dto.PlayerDataDto;
import ru.dzhager3354.backService.dto.PlayerDataPlaytimeDto;
import ru.dzhager3354.backService.repository.CustomPlayerDataRepository;

@Service
@AllArgsConstructor
public class PlayerDataTopic {
    private CustomPlayerDataRepository playerDataRepository;

    @KafkaListener(topics = "playerdata", groupId = "listener", containerFactory = "playerDataListener")
    public void create(PlayerDataDto dto) {
        System.out.println(dto);
        playerDataRepository.createPlayerData(dto);
    }

    @KafkaListener(topics = "playerdata-update", groupId = "listener", containerFactory = "playerPlaytimeListener")
    public void update(PlayerDataPlaytimeDto dto) {
        updatePlaytime(dto);
    }

    public void updatePlaytime(PlayerDataPlaytimeDto dto) {
        playerDataRepository.updatePlaytime(dto);
    }
}
