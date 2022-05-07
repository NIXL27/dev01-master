package com.fc.dao;

import com.fc.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    List<Student> findAll();
}
