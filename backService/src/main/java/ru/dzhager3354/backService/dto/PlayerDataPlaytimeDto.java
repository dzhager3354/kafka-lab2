package ru.dzhager3354.backService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDataPlaytimeDto {
    private Long id;
    private Integer playtime;
}