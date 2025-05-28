package ru.dzhager3354.apiService.controller;

import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dzhager3354.apiService.dto.PlayerDataDto;
import ru.dzhager3354.apiService.dto.PlayerDataPlaytimeDto;
import ru.dzhager3354.apiService.dto.PlayerPlaytimeDto;
import ru.dzhager3354.apiService.service.PlayerDataService;
import ru.dzhager3354.apiService.topic.PlayerDataTopic;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/playerdata")
public class PlayerDataController {
    private PlayerDataTopic topic;
    private PlayerDataService service;

    @PostMapping
    public String create(@RequestBody PlayerDataDto dto) {
        topic.create(dto);
        return "created " + dto;
    }

    @GetMapping("/total")
    public Long getPlaytimeByServer(@PathParam("server") String server) {
        return service.getPlaytimeByServer(server);
    }

    @GetMapping("/global")
    public List<PlayerPlaytimeDto> getGlobalPlaytime() {
        return service.getGlobalPlaytime();
    }

    @GetMapping("/top")
    public List<PlayerPlaytimeDto> getTopPlaytimeByServer(@PathParam("server") String server) {
        System.out.println(server);
        return service.getTopPlaytimeByServer(server);
    }

    @PutMapping
    public String updatePlaytime(@RequestBody PlayerDataPlaytimeDto dto) {
        topic.updatePlaytime(dto);
        return "updated " + dto;
    }
}
