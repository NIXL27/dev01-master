package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msgboard")
public class MessageBoardController {

    @Autowired
    private MessageBoardService messageBoardService;

    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return messageBoardService.getList(pageNum, pageSize, id);
    }

    @RequestMapping("add")
    public ResultVO insert(@RequestBody MessageBoardWithBLOBs messageBoard) {
        return messageBoardService.insert(messageBoard);
    }

    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return messageBoardService.delete(id);
    }

}









