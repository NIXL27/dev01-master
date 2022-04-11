package com.fc.controller;

import com.fc.entity.MessageBoardWithBLOBs;
import com.fc.service.MessageBoardService;
import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("msgboard")
public class MessageBoardController {

    @Autowired
    private MessageBoardService messageBoardService;

    @CrossOrigin
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return messageBoardService.getList(pageNo, pageSize, id);
    }

    @CrossOrigin
    @RequestMapping("add")
    public ResultVO insert(@RequestBody MessageBoardWithBLOBs messageBoard) {
        return messageBoardService.insert(messageBoard);
    }

    @CrossOrigin
    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return messageBoardService.delete(id);
    }

}









