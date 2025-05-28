package ru.dzhager3354.apiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDataDto {
    private String server;
    private Long playerId;
}
