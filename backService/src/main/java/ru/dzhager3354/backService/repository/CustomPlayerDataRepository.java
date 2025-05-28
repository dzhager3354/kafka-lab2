package ru.dzhager3354.backService.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.dzhager3354.backService.dto.PlayerDataDto;
import ru.dzhager3354.backService.dto.PlayerDataPlaytimeDto;

@Repository
public class CustomPlayerDataRepository {
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void createPlayerData(PlayerDataDto dto) {
        String query = "insert into player_data (server, playtime, player_id) values (:server, :playtime, :id)";
        manager.createNativeQuery(query)
                .setParameter("server", dto.getServer())
                .setParameter("playtime", 0)
                .setParameter("id", dto.getPlayerId())
                .executeUpdate();
    }

    @Transactional
    public void updatePlaytime(PlayerDataPlaytimeDto dto) {
        String query = "update player_data set playtime = :playtime where id = :id";
        manager.createNativeQuery(query)
                .setParameter("playtime", dto.getPlaytime())
                .setParameter("id", dto.getId())
                .executeUpdate();
    }
}
