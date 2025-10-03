package com.example.adolescentavos.controller;

import com.example.adolescentavos.dto.CriteriaDTO;
import com.example.adolescentavos.service.CriteriaService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/criteria")
@RequiredArgsConstructor
@Getter
public class CriteriaController {

    private final CriteriaService criteriaService;

    @GetMapping
    public ResponseEntity<List<CriteriaDTO>> getAllCriteria() {
        log.info("Fetching all criteria");
        return ResponseEntity.ok(criteriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CriteriaDTO> getCriteriaById(@PathVariable Long id) {
        log.info("Fetching criteria with id {}", id);
        CriteriaDTO criteria = criteriaService.findById(id);
        return (criteria != null) ? ResponseEntity.ok(criteria) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CriteriaDTO> createCriteria(@RequestBody CriteriaDTO dto) {
        log.info("Creating new criteria: {}", dto.getName());
        return ResponseEntity.ok(criteriaService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CriteriaDTO> updateCriteria(@PathVariable Long id, @RequestBody CriteriaDTO dto) {
        log.info("Updating criteria with id {}", id);
        dto.setId(id);
        return ResponseEntity.ok(criteriaService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCriteria(@PathVariable Long id) {
        log.info("Deleting criteria with id {}", id);
        criteriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
