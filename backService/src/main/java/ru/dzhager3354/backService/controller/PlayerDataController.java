package ru.dzhager3354.backService.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.dzhager3354.backService.dto.PlayerDataDto;
import ru.dzhager3354.backService.dto.PlayerDataPlaytimeDto;
import ru.dzhager3354.backService.dto.PlayerPlaytimeDto;
import ru.dzhager3354.backService.service.PlayerDataService;
import ru.dzhager3354.backService.topic.PlayerDataTopic;

import java.util.List;

@RestController
@RequestMapping("/playerdata")
@AllArgsConstructor
public class PlayerDataController {
    private PlayerDataService service;
    private PlayerDataTopic topic;

    @PostMapping
    public String create(@RequestBody PlayerDataDto dto) {
        topic.create(dto);
        return "created";
    }

    @GetMapping("/{server}")
    public List<PlayerPlaytimeDto> getTopPlaytimeByServer(@PathVariable("server") String server) {
        System.out.println(server);
        return service.getTopPlaytimeByServer(server);
    }

    @PutMapping
    public String updatePlaytime(@RequestBody PlayerDataPlaytimeDto dto) {
        topic.updatePlaytime(dto);
        return "update";
    }

    @GetMapping("/total/{server}")
    public Long getTotalPlaytime(@PathVariable("server") String server) {
        return service.calculateSummaryOnline(server);
    }

    @GetMapping("/global")
    public List<PlayerPlaytimeDto> getGlobalPlaytime() {
        return service.getTopPlaytimeSummary();
    }
}
