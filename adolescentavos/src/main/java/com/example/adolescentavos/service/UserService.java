package com.example.adolescentavos.service;

import com.example.adolescentavos.dto.UserDTO;
import com.example.adolescentavos.mapper.UserMapper;
import com.example.adolescentavos.model.User;
import com.example.adolescentavos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElse(null);
    }

    public UserDTO save(UserDTO dto) {
        User user = UserMapper.toEntity(dto);
        return UserMapper.toDTO(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
