package com.example.adolescentavos.mapper;

import com.example.adolescentavos.dto.UserDTO;
import com.example.adolescentavos.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDTO toDTO(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setBirthDate(user.getBirthDate());
        dto.setPhoto(user.getPhoto());
        dto.setTotalPoints(user.getTotalPoints());
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setBirthDate(dto.getBirthDate());
        user.setPhoto(dto.getPhoto());
        user.setTotalPoints(dto.getTotalPoints());
        return user;
    }
}
