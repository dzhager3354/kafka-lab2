package ru.dzhager3354.apiService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {
    private Long id;
    private String nickname;
    private Date dateRegistration;
}
