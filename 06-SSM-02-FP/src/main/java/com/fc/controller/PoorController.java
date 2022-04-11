package com.fc.controller;

import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    PoorService poorService;

    @CrossOrigin
    @RequestMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return poorService.getList(pageNo, pageSize, id);
    }

    @CrossOrigin
    @RequestMapping("add")
    public ResultVO insert(@RequestBody PoorWithBLOBs poor) {
        return poorService.insert(poor);
    }

    @CrossOrigin
    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return poorService.delete(id);
    }

    @CrossOrigin
    @RequestMapping("update")
    public ResultVO update(@RequestBody PoorWithBLOBs poor) {
        return poorService.update(poor);
    }
}
