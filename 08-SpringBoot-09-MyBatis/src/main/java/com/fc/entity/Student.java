package com.fc.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String info;
}
