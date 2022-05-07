package com.fc.service.impl;

import com.fc.dao.CarouselMapper;
import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.DataVO;
import com.fc.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarouselsServiceImpl implements CarouselService {

    @Autowired
    CarouselMapper carouselMapper;

    @Override
    public ResultVO getList(Integer pageNum, Integer pageSize, String id) {
        ResultVO resultVO = null;
        List<Carousel> carousels = new ArrayList<>();
        Carousel carousel;
        try {
            if (id != null) {
                carousel = carouselMapper.selectByPrimaryKey(Integer.parseInt(id));
                if (carousel != null) {
                    carousels.add(carousel);
                }
            }else {
                PageHelper.startPage(pageNum, pageSize);
                carousels = carouselMapper.selectByExample(null);
            }

            PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);
            DataVO dataVO = new DataVO(pageInfo.getTotal(), carousels, pageInfo.getPageNum(), pageInfo.getPageSize());
            resultVO = new ResultVO("查询成功", 200, true, dataVO);


        }catch (Exception e) {
            resultVO = new ResultVO("查询失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO insert(Carousel carousel) {
        ResultVO resultVO = null;

        if (carousel.getAvailable() == null) {
            carousel.setAvailable(false);
        }

        int rows = carouselMapper.insertSelective(carousel);

        if (rows > 0) {
            resultVO = new ResultVO("添加成功", 200, true, carousel);
        }else {
            resultVO = new ResultVO("添加失败", -100, false, new DataVO());
        }
        return resultVO;
    }

    @Override
    public ResultVO delete(Integer id) {
        ResultVO resultVO = null;

        int rows = carouselMapper.deleteByPrimaryKey(id);

        if (rows > 0) {
            resultVO = new ResultVO("删除成功", 200, true, new DataVO());
        }else {
            resultVO = new ResultVO("删除失败", -100, false, new DataVO());
        }

        return resultVO;
    }

    @Override
    public ResultVO update(Carousel carousel) {
        ResultVO resultVO = null;

        int rows = carouselMapper.updateByPrimaryKeySelective(carousel);

        if (rows > 0) {
            Carousel updatedCarousel = carouselMapper.selectByPrimaryKey(carousel.getId());

            resultVO = new ResultVO("修改成功", 200, true, updatedCarousel);
        }else {
            resultVO = new ResultVO("修改失败", -100, false, new DataVO());
        }
        return resultVO;
    }
}
