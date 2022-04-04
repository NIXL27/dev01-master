package com.fc.service;

import com.fc.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    List<User> findAll(Integer pageNo, Integer pageSize);

    int insert(User user);

    int delete(Integer id);

    int update(User user);
}
