package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getList")
    public Map<String, Object> find(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize, @RequestParam(value = "id", required = false, defaultValue = "-1")Integer id) {

        List<User> users = new ArrayList<>();
        User user;

        if (!id.equals(-1)) {
             user = userService.findById(id);
             if (user != null) {
                 users.add(user);
             }
        }else {
             users = userService.findAll(pageNo, pageSize);
        }

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        PageInfo<User> pageInfo = new PageInfo<>(users);

        if (users.isEmpty()) {
            map.put("message","NOTFOUND");
            map.put("code",404);
            map.put("success",false);
            map.put("data",dataMap);
        }else {
            map.put("message","OK");
            map.put("code",200);
            map.put("success",true);

            dataMap.put("total", pageInfo.getTotal());
            dataMap.put("list", users);
            dataMap.put("pageNum", pageInfo.getPageNum());
            dataMap.put("pageSize", pageInfo.getSize());

            map.put("data",dataMap);
        }

        return map;
    }

    @RequestMapping("add")
    public Map<String, Object> insert(User user) {

        int rows = userService.insert(user);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        if (rows > 0) {
            map.put("message","Ok");
            map.put("code",200);
            map.put("success",true);
            map.put("data",user);
        }else {
            map.put("message","NOTFOUND");
            map.put("code",404);
            map.put("success",false);
            map.put("data",dataMap);
        }
        return map;
    }

    @RequestMapping("delete")
    public Map<String, Object> delete(Integer id) {

        int rows = userService.delete(id);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        if (rows > 0) {
            map.put("message","Ok");
            map.put("code",200);
            map.put("success",true);
            map.put("data",dataMap);
        }else {
            map.put("message","NOTFOUND");
            map.put("code",404);
            map.put("success",false);
            map.put("data",dataMap);
        }
        return map;
    }

    @RequestMapping("update")
    public Map<String, Object> update(User user) {

        int rows = userService.update(user);

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        if (rows > 0) {
            map.put("message","Ok");
            map.put("code",200);
            map.put("success",true);
            map.put("data",user);
        }else {
            map.put("message","NOTFOUND");
            map.put("code",404);
            map.put("success",false);
            map.put("data",dataMap);
        }
        return map;
    }

}









