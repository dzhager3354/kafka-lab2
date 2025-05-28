package ru.dzhager3354.apiService.client;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import ru.dzhager3354.apiService.dto.PlayerPlaytimeDto;

import java.util.List;

@CrossOrigin("/**")
public interface PlayerDataClient {
    @GetExchange("/playerdata/total/{server}")
    Long getPlaytimeByServer(@PathVariable("server") String server);

    @GetExchange("/playerdata/global")
    List<PlayerPlaytimeDto> getGlobalPlaytime();

    @GetExchange("/playerdata/{server}")
    List<PlayerPlaytimeDto> getTopPlaytimeByServer(@PathVariable("server") String server);
}
