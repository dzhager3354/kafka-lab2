package ru.dzhager3354.apiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerPlaytimeDto {
    private String nickname;
    private Long playtime;
}
