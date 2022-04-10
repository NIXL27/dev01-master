package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVO;

import java.util.List;

public interface UserService {

    ResultVO getList(Integer pageNo, Integer pageSize, String id);

    ResultVO insert(User user);

    ResultVO delete(Long id);

    ResultVO update(User user);
}
