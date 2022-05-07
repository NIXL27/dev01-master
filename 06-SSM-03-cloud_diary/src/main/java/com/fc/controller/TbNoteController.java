package com.fc.controller;

import com.fc.service.TbNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("note")
public class TbNoteController {
    @Autowired
    private TbNoteService tbNoteService;

    @RequestMapping("view")
    public ModelAndView getList(HttpServletRequest request) {
        return tbNoteService.getList(request);
    }

    @RequestMapping("detail")
    public ModelAndView getNote(Integer id) {
        return tbNoteService.getNote(id);
    }
}
