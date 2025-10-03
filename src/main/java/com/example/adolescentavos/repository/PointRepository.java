package com.example.adolescentavos.repository;

import com.example.adolescentavos.model.Point;
import com.example.adolescentavos.repository.custom.PointCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<Point, Long>, PointCustomRepository {
    List<Point> findPointsByUserIdAndDateRange(Long userId, LocalDate startDate, LocalDate endDate);
}