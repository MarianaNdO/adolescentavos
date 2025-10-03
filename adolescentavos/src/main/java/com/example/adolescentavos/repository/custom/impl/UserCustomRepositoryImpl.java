package com.example.adolescentavos.repository.custom.impl;

import com.example.adolescentavos.model.User;
import com.example.adolescentavos.repository.custom.UserCustomRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findTopUsersByPoints(int limit) {
        String jpql = "SELECT u FROM User u ORDER BY u.totalPoints DESC";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public List<User> findUsersByNameContainingIgnoreCase(String name) {
        String jpql = "SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :name, '%'))";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
