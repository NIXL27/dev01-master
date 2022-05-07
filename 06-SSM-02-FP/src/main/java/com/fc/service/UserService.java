package com.fc.service;

import com.fc.entity.User;
import com.fc.vo.ResultVO;

public interface UserService {

    ResultVO getList(Integer pageNum, Integer pageSize, String id);

    ResultVO insert(User user);

    ResultVO delete(Long id);

    ResultVO update(User user);
}
