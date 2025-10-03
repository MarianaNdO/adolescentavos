package com.example.adolescentavos.dto;

import lombok.Data;

@Data
public class CriteriaDTO {

    private Long id;
    private String name;
    private Integer points;

    public CriteriaDTO() {}

    public CriteriaDTO(Long id, String name, Integer points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

}
