package com.fc.service;

import com.fc.entity.User;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Integer id);

    Integer findCount();

    int insert(User user);

    int update(User user);

    int delete(Integer id);
}
