package ru.dzhager3354.backService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dzhager3354.backService.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
