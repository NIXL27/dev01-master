package com.fc.controller;

import com.fc.entity.AlleviationWithBLOBs;
import com.fc.service.AlleviationService;
import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("alleviation")
public class AlleviationController {
    @Autowired
    AlleviationService alleviationService;

    @RequestMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return alleviationService.getList(pageNum, pageSize, id);
    }

    @RequestMapping("add")
    public ResultVO insert(@RequestBody AlleviationWithBLOBs alleviation) {
        return alleviationService.insert(alleviation);
    }

    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return alleviationService.delete(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody AlleviationWithBLOBs alleviation) {
        return alleviationService.update(alleviation);
    }
}
