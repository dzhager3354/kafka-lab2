package ru.dzhager3354.apiService.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dzhager3354.apiService.dto.PlayerDto;
import ru.dzhager3354.apiService.entity.Player;
import ru.dzhager3354.apiService.service.PlayerService;
import ru.dzhager3354.apiService.topic.PlayerTopic;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/player")
public class PlayerController {
    private PlayerService service;
    private PlayerTopic topic;

    @PostMapping
    public String createPlayer(@RequestBody PlayerDto dto) {
        topic.createPlayer(dto);
        System.out.println(dto);
        return "Player " + dto + " created";
    }

    @GetMapping
    public List<Player> getPlayers() {
        return service.getPlayers();
    }
}
