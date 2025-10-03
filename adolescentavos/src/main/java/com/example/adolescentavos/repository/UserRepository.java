package com.example.adolescentavos.repository;

import com.example.adolescentavos.model.User;
import com.example.adolescentavos.repository.custom.UserCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {
    List<User> findTopUsersByPoints(int limit);
    List<User> findUsersByNameContainingIgnoreCase(String name);
}
