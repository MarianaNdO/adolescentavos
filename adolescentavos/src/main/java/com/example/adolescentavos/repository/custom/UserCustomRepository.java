package com.example.adolescentavos.repository.custom;

import com.example.adolescentavos.model.User;

import java.util.List;

public interface UserCustomRepository {
    List<User> findTopUsersByPoints(int limit);
    List<User> findUsersByNameContainingIgnoreCase(String name);
}
