package com.example.adolescentavos.service;

import com.example.adolescentavos.dto.PointDTO;
import com.example.adolescentavos.mapper.PointMapper;
import com.example.adolescentavos.model.Criteria;
import com.example.adolescentavos.model.Point;
import com.example.adolescentavos.model.User;
import com.example.adolescentavos.repository.CriteriaRepository;
import com.example.adolescentavos.repository.PointRepository;
import com.example.adolescentavos.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PointService {

    private final PointRepository pointsRepository;
    private final UserRepository userRepository;
    private final CriteriaRepository criteriaRepository;

    public List<PointDTO> findAll() {
        return pointsRepository.findAll().stream()
                .map(PointMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PointDTO findById(Long id) {
        return pointsRepository.findById(id)
                .map(PointMapper::toDTO)
                .orElse(null);
    }

    public PointDTO save(PointDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Criteria criteria = criteriaRepository.findById(dto.getCriteriaId())
                .orElseThrow(() -> new RuntimeException("Criteria not found"));

        Point point = PointMapper.toEntity(dto, user, criteria);
        return PointMapper.toDTO(pointsRepository.save(point));
    }

    public void delete(Long id) {
        pointsRepository.deleteById(id);
    }
}
