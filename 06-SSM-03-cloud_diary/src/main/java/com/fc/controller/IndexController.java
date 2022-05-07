package com.fc.controller;

import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.service.TbNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private TbNoteService tbNoteService;

    @RequestMapping("page")
    public ModelAndView page(ModelAndView modelAndView, HttpServletRequest request) {
        return tbNoteService.page(modelAndView, request);
    }
}
