package com.fc.service;

import com.fc.entity.Carousel;
import com.fc.vo.ResultVO;


public interface CarouselService {
    ResultVO getList(Integer pageNum, Integer pageSize, String id);

    ResultVO insert(Carousel carousel);

    ResultVO delete(Integer id);

    ResultVO update(Carousel carousel);
}
