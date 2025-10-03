package com.example.adolescentavos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private String photo;
    private Integer totalPoints;

    public UserDTO() {}

    public UserDTO(Long id, String name, LocalDate birthDate, String photo, Integer totalPoints) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.photo = photo;
        this.totalPoints = totalPoints;
    }
}
