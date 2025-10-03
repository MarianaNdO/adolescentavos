package com.example.adolescentavos.mapper;

import com.example.adolescentavos.dto.CriteriaDTO;
import com.example.adolescentavos.model.Criteria;
import org.springframework.stereotype.Component;

@Component
public class CriteriaMapper {

    public static CriteriaDTO toDTO(Criteria entity) {
        if (entity == null) return null;
        CriteriaDTO dto = new CriteriaDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPoints(entity.getPoints());
        return dto;
    }

    public static Criteria toEntity(CriteriaDTO dto) {
        if (dto == null) return null;
        Criteria entity = new Criteria();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setPoints(dto.getPoints());
        return entity;
    }
}
