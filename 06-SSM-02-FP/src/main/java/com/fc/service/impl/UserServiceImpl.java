package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, String id) {
        ResultVO resultVO = null;
        List<User> users = new ArrayList<>();
        User user;
        try {
            if (id != null) {
                 user = userMapper.selectByPrimaryKey(Long.parseLong(id));
                if (user != null) {
                    users.add(user);
                }
            }else {
                PageHelper.startPage(pageNum, pageSize);
                users = userMapper.selectByExample(null);
            }

            PageInfo<User> pageInfo = new PageInfo<>(users);
            DataVO dataVO = new DataVO(pageInfo.getTotal(), users, pageInfo.getPageNum(), pageInfo.getPageSize());
            resultVO = new ResultVO("查询成功", 200, true, dataVO);


        }catch (Exception e) {
            resultVO = new ResultVO("查询失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO insert(User user) {
        ResultVO resultVO = null;

        if (user != null) {
            user.setCreateTime(new Date());
        }

        int rows = userMapper.insertSelective(user);

        if (rows > 0) {
            resultVO = new ResultVO("添加成功", 200, true, user);
        }else {
            resultVO = new ResultVO("添加失败", -100, false, new DataVO());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Long id) {
        ResultVO resultVO = null;

        int rows = userMapper.deleteByPrimaryKey(id);

        if (rows > 0) {
            resultVO = new ResultVO("删除成功", 200, true, new DataVO());
        }else {
            resultVO = new ResultVO("删除失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO update(User user) {
        ResultVO resultVO = null;

        int rows = userMapper.updateByPrimaryKeySelective(user);

        if (rows > 0) {
            User updatedUser = userMapper.selectByPrimaryKey(user.getId());

            resultVO = new ResultVO("修改成功", 200, true, updatedUser);
        }else {
            resultVO = new ResultVO("修改失败", -100, false, new DataVO());
        }
        return resultVO;
    }
}
