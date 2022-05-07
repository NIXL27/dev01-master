package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    CarouselService carouselService;

    @RequestMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return carouselService.getList(pageNum, pageSize, id);
    }

    @RequestMapping("add")
    public ResultVO insert(@RequestBody Carousel carousel) {
        return carouselService.insert(carousel);
    }

    @RequestMapping("delete")
    public ResultVO delete(Integer id) {
        return carouselService.delete(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody Carousel carousel) {
        return carouselService.update(carousel);
    }
}
