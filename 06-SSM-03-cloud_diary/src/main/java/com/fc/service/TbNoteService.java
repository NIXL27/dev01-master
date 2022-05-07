package com.fc.service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public interface TbNoteService {
    ModelAndView page(ModelAndView modelAndView, HttpServletRequest request);

    ModelAndView getList(HttpServletRequest request);

    ModelAndView getNote(Integer id);
}
