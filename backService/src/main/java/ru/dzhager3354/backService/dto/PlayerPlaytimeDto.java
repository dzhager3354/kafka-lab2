package ru.dzhager3354.backService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPlaytimeDto {
    private String nickname;
    private Integer playtime;
}