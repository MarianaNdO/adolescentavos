package com.example.adolescentavos.repository.custom.impl;

import com.example.adolescentavos.model.Point;
import com.example.adolescentavos.repository.custom.PointCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PointCustomRepositoryImpl implements PointCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Point> findPointsByUserIdAndDateRange(Long userId, LocalDate startDate, LocalDate endDate) {
        String jpql = "SELECT p FROM Point p WHERE p.user.id = :userId AND p.dateAssigned BETWEEN :startDate AND :endDate";
        TypedQuery<Point> query = entityManager.createQuery(jpql, Point.class);
        query.setParameter("userId", userId);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }
}
