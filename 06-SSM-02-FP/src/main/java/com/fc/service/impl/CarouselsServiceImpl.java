package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarouselsServiceImpl implements CarouselService {

    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public Carousel findById(Integer id) {
        return carouselMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Carousel> findAll(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        return carouselMapper.selectByExample(null);
    }
}
