package com.example.adolescentavos.repository.custom;

import com.example.adolescentavos.model.Point;

import java.time.LocalDate;
import java.util.List;

public interface PointCustomRepository {
    List<Point> findPointsByUserIdAndDateRange(Long userId, LocalDate startDate, LocalDate endDate);
}
