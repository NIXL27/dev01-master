package com.fc.service.impl;

import com.fc.dao.TbNoteMapper;
import com.fc.dao.TbNoteTypeMapper;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.TbNoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbNoteTypeServiceImpl implements TbNoteTypeService {
    @Autowired
    private TbNoteTypeMapper tbNoteTypeMapper;

    @Override
    public ModelAndView getList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        TbUser user = (TbUser) session.getAttribute("user");

        List<TbNoteType> tbNoteTypes = tbNoteTypeMapper.selectByUserId(user.getId());

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("list",tbNoteTypes);
        modelAndView.addObject("menu_page","type");
        modelAndView.addObject("changePage","/type/list.jsp");
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }

    @Override
    public Map<String, Object> addOrUpdate(TbNoteType tbNoteType,HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        HttpSession session = request.getSession();

        TbUser user = (TbUser) session.getAttribute("user");

        if (tbNoteType.getId() == null) {
            tbNoteType.setUserId(user.getId());
            int addRows = tbNoteTypeMapper.insertSelective(tbNoteType);
            if (addRows > 0) {
                map.put("code", 1);
                map.put("message","添加成功");
                map.put("data",tbNoteType.getId());
            }else {
                map.put("code", 0);
                map.put("message","添加失败");
            }
        }else {
            int updateRows = tbNoteTypeMapper.updateByPrimaryKeySelective(tbNoteType);
            if (updateRows > 0) {
                map.put("code", 1);
                map.put("message","修改成功");
            }else {
                map.put("code", 0);
                map.put("message","修改失败");
            }
        }

        return map;
    }

    @Override
    public Map<String, Object> delete(Integer id) {
        Integer count = tbNoteTypeMapper.selectTypeWithNote(id);

        Map<String, Object> map = new HashMap<>();

        if (count > 0) {
            map.put("code",0);
            map.put("message","删除失败");
        }else {
            int rows = tbNoteTypeMapper.deleteByPrimaryKey(id);
            if (rows > 0){
                map.put("code",1);
                map.put("message","删除成功");
            }else {
                map.put("code",0);
                map.put("message","删除失败");
            }
        }
        return map;
    }
}
