package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return userService.getList(pageNum, pageSize, id);
    }

    @RequestMapping("add")
    public ResultVO insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return userService.delete(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody User user) {
        return userService.update(user);
    }

}









