package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.TypeService;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("type")
public class NoteTypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("list")
    public ModelAndView list(ModelAndView mv, HttpSession session) {

        TbUser user = (TbUser) session.getAttribute("user");

        List<TbNoteType> types = typeService.getTypes(user.getId());

        mv.addObject("list", types);
        mv.addObject("menu_page", "type");
        mv.addObject("changePage", "/type/list.jsp");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }

    @PostMapping("addOrUpdate")
    @ResponseBody
    public ResultVO addOrUpdate(TbNoteType tbNoteType, HttpSession session) {
        ResultVO vo;

        TbUser user = (TbUser) session.getAttribute("user");

        // 没有id说明是添加操作
        if (tbNoteType.getId() == null) {
            vo = typeService.add(tbNoteType, user.getId());
        }else {
            vo = typeService.update(tbNoteType);
        }
        return vo;
    }

    @GetMapping("delete")
    @ResponseBody
    public ResultVO delete(@RequestParam Integer id) {
        return typeService.delete(id);
    }
}
