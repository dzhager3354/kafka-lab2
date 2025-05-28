package ru.dzhager3354.backService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.dzhager3354.backService.dto.PlayerPlaytimeDto;
import ru.dzhager3354.backService.entity.PlayerData;

import java.util.List;

public interface PlayerDataRepository extends JpaRepository<PlayerData, Long> {
    @Query(value = "select sum(playtime) from player_data where server = ?1", nativeQuery = true)
    Long calculateSummaryOnline(String server);

    @Query(value = "select nickname, playtime from players join player_data on players.id = player_data.player_id where server = ?1 order by playtime desc", nativeQuery = true)
    List<PlayerPlaytimeDto> getTopPlaytimeByServer(String server);

    @Query(value = "select nickname, cast(sum(playtime) as integer) as playtime from players join player_data on players.id = player_data.player_id group by nickname order by playtime desc", nativeQuery = true)
    List<PlayerPlaytimeDto> getTopPlaytimeSummary();
}
