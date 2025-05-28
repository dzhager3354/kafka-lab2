package ru.dzhager3354.backService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_data")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String server;
    @Column(nullable = false)
    private Integer playtime;
    @ManyToOne
    @JoinColumn
    private Player player;
}
