package com.fc.controller;

import com.fc.entity.Collection;
import com.fc.service.CollectionService;
import com.fc.vo.ResultVO;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @CrossOrigin
    @GetMapping("getlist")
    public ResultVO getList(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, String id) {
        return collectionService.getList(pageNo, pageSize, id);
    }

    @CrossOrigin
    @RequestMapping("add")
    public ResultVO insert(@RequestBody Collection collection) {
        return collectionService.insert(collection);
    }

    @CrossOrigin
    @RequestMapping("delete")
    public ResultVO delete(Long id) {
        return collectionService.delete(id);
    }

    @CrossOrigin
    @RequestMapping("update")
    public ResultVO update(@RequestBody Collection collection) {
        return collectionService.update(collection);
    }

}









