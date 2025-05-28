package ru.dzhager3354.apiService.client;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.service.annotation.GetExchange;
import ru.dzhager3354.apiService.entity.Player;

import java.util.List;

@CrossOrigin("/**")
public interface PlayerClient {
    @GetExchange("/player")
    List<Player> getPlayers();
}
