package com.fc.controller;

import com.fc.entity.Carousel;
import com.fc.entity.User;
import com.fc.service.CarouselService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("carousel")
public class carouselController {
    @Autowired
    CarouselService carouselService;

    @RequestMapping("getList")
    public Map<String, Object> find(@RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", required = false, defaultValue = "3") Integer pageSize, @RequestParam(value = "id", required = false, defaultValue = "-1")Integer id) {

        List<Carousel> carousels = new ArrayList<>();
        Carousel carousel;

        if (!id.equals(-1)) {
            carousel = carouselService.findById(id);
            if (carousel != null) {
                carousels.add(carousel);
            }
        }else {
            carousels = carouselService.findAll(pageNo, pageSize);
        }

        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        PageInfo<Carousel> pageInfo = new PageInfo<>(carousels);

        if (carousels.isEmpty()) {
            map.put("message","NOTFOUND");
            map.put("code",404);
            map.put("success",false);
            map.put("data",dataMap);
        }else {
            map.put("message","OK");
            map.put("code",200);
            map.put("success",true);

            dataMap.put("total", pageInfo.getTotal());
            dataMap.put("list", carousels);
            dataMap.put("pageNum", pageInfo.getPageNum());
            dataMap.put("pageSize", pageInfo.getSize());

            map.put("data",dataMap);
        }

        return map;
    }
}
