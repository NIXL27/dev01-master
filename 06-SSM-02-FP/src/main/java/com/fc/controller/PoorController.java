package com.fc.controller;

import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    PoorService poorService;

    @RequestMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return poorService.getList(pageNum, pageSize, id);
    }

    @RequestMapping("add")
    public ResultVO insert(@RequestBody PoorWithBLOBs poor) {
        return poorService.insert(poor);
    }

    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return poorService.delete(id);
    }

    @RequestMapping("update")
    public ResultVO update(@RequestBody PoorWithBLOBs poor) {
        return poorService.update(poor);
    }
}
