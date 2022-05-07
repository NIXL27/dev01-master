package com.fc.service;

import com.fc.entity.TbNoteType;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface TbNoteTypeService {
    ModelAndView getList(HttpServletRequest request);

    Map<String, Object> addOrUpdate(TbNoteType tbNoteType,HttpServletRequest request);

    Map<String, Object> delete(Integer id);
}

