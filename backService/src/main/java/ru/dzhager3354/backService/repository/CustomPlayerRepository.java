package ru.dzhager3354.backService.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ru.dzhager3354.backService.dto.PlayerDto;

@Repository
public class CustomPlayerRepository {
    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public void create(PlayerDto dto) {
        String query = "insert into players (nickname) values (:nickname)";
        manager.createNativeQuery(query)
                .setParameter("nickname", dto.getNickname())
                .executeUpdate();
    }
}
