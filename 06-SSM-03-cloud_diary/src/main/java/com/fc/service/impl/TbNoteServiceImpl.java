package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbNoteTypeExample;
import com.fc.entity.TbUser;
import com.fc.service.TbNoteService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbNoteServiceImpl implements TbNoteService {

    @Autowired
    TbNoteMapper tbNoteMapper;
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;

    @Override
    public ModelAndView page(ModelAndView modelAndView, HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        TbUser user = (TbUser) session.getAttribute("user");

//        PageHelper.startPage(pageNum, pageSize);
//        List<TbNote> pageInfo = tbNoteMapper.findAll(user.getId());
//
//        session.setAttribute("page",pageInfo);
//
        modelAndView.setViewName("forward:/index.jsp");

        return modelAndView;
    }

    @Override
    public ModelAndView getList(HttpServletRequest request) {

        String noteId = request.getParameter("noteId");

        ModelAndView modelAndView = new ModelAndView();

        if (noteId != null && !noteId.equals("")) {
            TbNote tbNote = tbNoteMapper.selectByPrimaryKey(Integer.parseInt(noteId));

            modelAndView.addObject("noteInfo",tbNote);
        }else {
            HttpSession session = request.getSession(false);

            TbUser user = (TbUser) session.getAttribute("user");

            List<TbNoteType> tbNoteTypes = tbNoteTypeMapper.selectByUserId(user.getId());

            modelAndView.addObject("typeList",tbNoteTypes);
            modelAndView.addObject("changePage","/note/view.jsp");
            modelAndView.setViewName("/index.jsp");

        }

        return modelAndView;
    }

    @Override
    public ModelAndView getNote(Integer id) {
        List<TbNote> tbNotes = tbNoteMapper.selectNoteWithTypeName(id);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("note",tbNotes);
        modelAndView.addObject("changePage","/note/detail.jsp");
        modelAndView.setViewName("/index.jsp");

        return modelAndView;
    }
}
