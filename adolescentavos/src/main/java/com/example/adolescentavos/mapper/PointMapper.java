package com.example.adolescentavos.mapper;

import com.example.adolescentavos.dto.PointDTO;
import com.example.adolescentavos.model.Criteria;
import com.example.adolescentavos.model.Point;
import com.example.adolescentavos.model.User;

public class PointMapper {

    private PointMapper() {}

    public static Point toEntity(PointDTO dto, User user, Criteria criteria) {
        Point point = new Point();
        point.setId(dto.getId());
        point.setUser(user);
        point.setCriteria(criteria);
        return point;
    }

    public static PointDTO toDTO(Point point) {
        PointDTO dto = new PointDTO();
        dto.setId(point.getId());
        dto.setUserId(point.getUser().getId());
        dto.setCriteriaId(point.getCriteria().getId());
        return dto;
    }
}
