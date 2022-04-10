package com.fc.controller;

import com.fc.entity.Poor;
import com.fc.entity.PoorWithBLOBs;
import com.fc.service.PoorService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poor")
public class PoorController {
    @Autowired
    PoorService poorService;

    @RequestMapping("getList")
    public ResultVO getList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return poorService.getList(pageNo, pageSize, id);
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
