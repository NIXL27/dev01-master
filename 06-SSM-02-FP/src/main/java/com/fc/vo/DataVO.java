package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataVO <T>{
    private Long total;
    List<T> list;
    private Integer pageNum;
    private Integer pageSize;
}
