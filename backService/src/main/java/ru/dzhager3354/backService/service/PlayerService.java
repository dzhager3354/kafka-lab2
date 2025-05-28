package ru.dzhager3354.backService.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dzhager3354.backService.entity.Player;
import ru.dzhager3354.backService.repository.PlayerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlayerService {
    private PlayerRepository repository;

    public List<Player> getPlayers() {
        System.out.println(repository.findAll());
        return repository.findAll();
    }
}
