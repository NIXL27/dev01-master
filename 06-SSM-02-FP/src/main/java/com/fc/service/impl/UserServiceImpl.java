package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id.longValue());
    }

    @Override
    public List<User> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return userMapper.selectByExample(null);
    }

    @Override
    public int insert(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteByPrimaryKey(id.longValue());
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }
}
