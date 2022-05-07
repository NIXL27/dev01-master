package com.fc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("student")
public class StudentController {
    @Value("${student.name}")
    private String name;
    @Value("${student.age}")
    private Integer age;

    @RequestMapping("test")
    public Map<String, Object> testYML() {
        Map<String, Object> map = new HashMap<>();
        System.out.println(name);
        map.put("name", name);
        map.put("age",age);
        return map;
    }
    @RequestMapping("get")
    public String get() {
        return name + ":" + age;
    }
}
