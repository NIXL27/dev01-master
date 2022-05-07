package com.fc.controller;

import com.fc.entity.TbNote;
import com.fc.entity.TbNoteType;
import com.fc.entity.TbUser;
import com.fc.service.NoteService;
import com.fc.service.TypeService;
import com.fc.vo.NoteVO;
import com.fc.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private TypeService typeService;

    @PostMapping("addOrUpdate")
    public ModelAndView addOrUpdate(TbNote note, ModelAndView mv) {
        mv.addObject("menu_page","note");

        ResultVO resultVO;

        // 如果日记id不为空，就执行修改
        if (note.getId() != null) {
            resultVO = noteService.update(note);
        }else {
            resultVO = noteService.add(note);
        }

        if (resultVO.getSuccess()) {
            // 使用重定向
            mv.setViewName("redirect:/index/page");
        } else {
            mv.addObject("resultInfo", resultVO);
            mv.addObject("id", note.getId());
            mv.setViewName("forward:/note/view");
        }
        return mv;
    }

    @GetMapping("view")
    public ModelAndView noteView(Integer id, ModelAndView mv, HttpSession session) {
        if (id != null) {
            NoteVO noteVO = noteService.getNoteById(id);

            mv.addObject("noteInfo",noteVO);
        }

        TbUser user = (TbUser) session.getAttribute("user");

        List<TbNoteType> typeList = typeService.getTypes(user.getId());

        mv.addObject("typeList", typeList);
        mv.addObject("changePage","/note/view.jsp");
        mv.addObject("menu_page","note");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }

    @GetMapping("detail")
    public ModelAndView getNoteById(Integer id, ModelAndView mv) {

        NoteVO noteVO = noteService.getNoteById(id);

        mv.addObject("note", noteVO);
        mv.addObject("changePage", "/note/detail.jsp");
        mv.addObject("menu_page", "note");

        mv.setViewName("forward:/index.jsp");

        return mv;
    }

    @GetMapping("delete")
    @ResponseBody
    public ResultVO delete(@RequestParam Integer id) {
        return noteService.delete(id);
    }
}
