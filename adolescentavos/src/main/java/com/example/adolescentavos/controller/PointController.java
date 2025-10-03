package com.example.adolescentavos.controller;

import com.example.adolescentavos.dto.PointDTO;
import com.example.adolescentavos.service.PointService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/points")
@RequiredArgsConstructor
public class PointController {

    private final PointService pointsService;

    @GetMapping
    public ResponseEntity<List<PointDTO>> getAllPoints() {
        log.info("Fetching all points");
        return ResponseEntity.ok(pointsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PointDTO> getPointsById(@PathVariable Long id) {
        log.info("Fetching points with id {}", id);
        PointDTO points = pointsService.findById(id);
        return (points != null) ? ResponseEntity.ok(points) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PointDTO> createPoints(@RequestBody PointDTO dto) {
        log.info("Assigning points: userId={}, criteriaId={}, points={}", dto.getUserId(), dto.getCriteriaId(), dto.getPoints());
        return ResponseEntity.ok(pointsService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PointDTO> updatePoints(@PathVariable Long id, @RequestBody PointDTO dto) {
        log.info("Updating points with id {}", id);
        dto.setId(id);
        return ResponseEntity.ok(pointsService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoints(@PathVariable Long id) {
        log.info("Deleting points with id {}", id);
        pointsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
