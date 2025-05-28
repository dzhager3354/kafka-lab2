package ru.dzhager3354.apiService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerData {
    private Long id;
    private String server;
    private Integer playtime;
    private Player player;
}
