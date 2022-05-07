package com.fc.controller;

import com.fc.entity.TbUser;
import com.fc.service.UserService;
import com.fc.vo.ResultVO;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ModelAndView login(TbUser user,
                              Integer remember,
                              HttpSession session,
                              HttpServletResponse response,
                              ModelAndView mv) {

        ResultVO resultVO = userService.login(user.getUsername(), user.getPassword());

        System.out.println(resultVO);

        if (resultVO != null){
            if (resultVO.getSuccess()) {
                session.setAttribute("user",resultVO.getData());

                Cookie cookie;

                if (remember != null && remember == 1) {
                    cookie = new Cookie("JSESSIONID",session.getId());

                    // 半小时
                    cookie.setMaxAge(30 * 60);
                }else {
                    cookie = new Cookie("JSESSIONID","");

                    // 浏览器关闭时自动销毁
                    cookie.setMaxAge(-1);
                }

                // 发送到浏览器
                response.addCookie(cookie);

                mv.setViewName("forward:/index/page");
            } else {
                // 登录失败
                mv.addObject("resultInfo",resultVO);
                mv.setViewName("forward:/login.jsp");
            }

        }

        return mv;
    }

    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mv, HttpSession session, HttpServletResponse response) {
        // 销毁session
        session.invalidate();

        Cookie cookie = new Cookie("JSESSIONID",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        mv.setViewName("redirect:/login.jsp");
        return mv;
    }

    @GetMapping("userCenter")
    public ModelAndView userCenter(ModelAndView mv) {

        mv.addObject("menu_page", "user");
        mv.addObject("changePage", "/user/info.jsp");

        mv.setViewName("forward:/index.jsp");
        return mv;
    }

    @GetMapping("checkNick")
    @ResponseBody
    public Integer checkNick(String nick) {
        return userService.chekNick(nick);
    }

    @PostMapping("update")
    public ModelAndView update(MultipartFile img, TbUser user, HttpSession session, ModelAndView mv) {
        TbUser tbUser = (TbUser) session.getAttribute("user");

        // 修改操作需要拿到id
        user.setId(tbUser.getId());

        ResultVO vo = userService.update(img, user);

        session.setAttribute("user", vo.getData());

        mv.setViewName("redirect:userCenter");

        return mv;
    }
}
