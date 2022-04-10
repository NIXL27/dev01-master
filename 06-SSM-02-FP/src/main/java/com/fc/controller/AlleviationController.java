package com.fc.controller;

import com.fc.entity.Alleviation;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    AlleviationService alleviationService;

    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        System.out.println("id-"+id);
        return alleviationService.getList(pageNo, pageSize, id);
    }

    @RequestMapping("add")
    public ResultVO insert(@RequestBody Alleviation alleviation) {
        return alleviationService.insert(alleviation);
    }

    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return alleviationService.delete(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody Alleviation alleviation) {
        return alleviationService.update(alleviation);
    }
}
