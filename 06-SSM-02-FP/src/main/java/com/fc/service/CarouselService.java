package com.fc.service;

import com.fc.entity.Carousel;

import java.util.List;

public interface CarouselService {
    Carousel findById(Integer id);

    List<Carousel> findAll(Integer pageNo, Integer pageSize);
}
