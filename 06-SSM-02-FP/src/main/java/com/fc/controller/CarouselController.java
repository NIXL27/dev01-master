package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.entity.User;
import com.fc.service.CarouselService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carousel")
public class CarouselController {
    @Autowired
    CarouselService carouselService;

    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return carouselService.getList(pageNo, pageSize, id);
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
