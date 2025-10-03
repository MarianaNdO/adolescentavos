package com.example.adolescentavos.service;

import com.example.adolescentavos.dto.CriteriaDTO;
import com.example.adolescentavos.mapper.CriteriaMapper;
import com.example.adolescentavos.model.Criteria;
import com.example.adolescentavos.repository.CriteriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CriteriaService {

    private final CriteriaRepository criteriaRepository;
    private final CriteriaMapper criteriaMapper;

    public List<CriteriaDTO> findAll() {
        return criteriaRepository.findAll().stream()
                .map(CriteriaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CriteriaDTO findById(Long id) {
        return criteriaRepository.findById(id)
                .map(CriteriaMapper::toDTO)
                .orElse(null);
    }

    public CriteriaDTO save(CriteriaDTO dto) {
        Criteria criteria = criteriaMapper.toEntity(dto);
        return criteriaMapper.toDTO(criteriaRepository.save(criteria));
    }

    public void delete(Long id) {
        criteriaRepository.deleteById(id);
    }
}
