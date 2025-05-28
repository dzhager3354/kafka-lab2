package ru.dzhager3354.backService.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dzhager3354.backService.dto.PlayerDto;
import ru.dzhager3354.backService.entity.Player;
import ru.dzhager3354.backService.service.PlayerService;
import ru.dzhager3354.backService.topic.PlayerTopic;

import java.util.List;

@RestController
@RequestMapping("/player")
@AllArgsConstructor
public class PlayerController {
    private PlayerService service;
    private PlayerTopic topic;

    @PostMapping
    public String createPlayer(@RequestBody PlayerDto dto) {
        topic.createPlayer(dto);
        return "created";
    }

    @GetMapping
    public List<Player> getPlayers() {
        return service.getPlayers();
    }
}
