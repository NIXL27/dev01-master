package com.fc.controller;

import com.fc.entity.TbNoteType;
import com.fc.service.TbNoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("type")
public class TbNoteTypeController {
    @Autowired
    private TbNoteTypeService tbNoteTypeService;

    @RequestMapping("list")
    public ModelAndView getList(HttpServletRequest request) {
        return tbNoteTypeService.getList(request);
    }

    @RequestMapping("addOrUpdate")
    public Map<String, Object> addOrUpdate(TbNoteType tbNoteType,HttpServletRequest request) {
        return tbNoteTypeService.addOrUpdate(tbNoteType,request);
    }

    @RequestMapping("delete")
    public Map<String,Object> delete(Integer id) {
        return tbNoteTypeService.delete(id);
    }
}
