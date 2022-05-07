package com.fc.service.impl;

import com.fc.service.UserService;
import com.fc.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserVO login(String username, String password) {
        UserVO userVO = null;
        if (username.equals("mk.W") && password.equals("123456")){
             userVO = new UserVO(1, username, new Date());
        }
        return userVO;
    }
}
