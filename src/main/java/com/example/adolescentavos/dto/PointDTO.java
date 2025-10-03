package com.example.adolescentavos.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PointDTO {

    private Long id;
    private Long userId;
    private Long criteriaId;
    private Integer points;
    private LocalDate dateAssigned;

    public PointDTO() {}

    public PointDTO(Long id, Long userId, Long criteriaId, Integer points, LocalDate dateAssigned) {
        this.id = id;
        this.userId = userId;
        this.criteriaId = criteriaId;
        this.points = points;
        this.dateAssigned = dateAssigned;
    }

}
