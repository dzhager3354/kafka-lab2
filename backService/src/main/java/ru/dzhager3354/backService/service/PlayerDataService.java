package ru.dzhager3354.backService.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.dzhager3354.backService.dto.PlayerDataDto;
import ru.dzhager3354.backService.dto.PlayerDataPlaytimeDto;
import ru.dzhager3354.backService.dto.PlayerPlaytimeDto;
import ru.dzhager3354.backService.repository.CustomPlayerDataRepository;
import ru.dzhager3354.backService.repository.PlayerDataRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerDataService {
    private PlayerDataRepository repository;

    public List<PlayerPlaytimeDto> getTopPlaytimeByServer(String server) {
        return repository.getTopPlaytimeByServer(server);
    }

    public Long calculateSummaryOnline(String server) {
        return repository.calculateSummaryOnline(server);
    }

    public List<PlayerPlaytimeDto> getTopPlaytimeSummary() {
        return repository.getTopPlaytimeSummary();
    }
}
