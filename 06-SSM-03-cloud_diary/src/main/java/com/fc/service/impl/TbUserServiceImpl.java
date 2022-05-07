package com.fc.service.impl;

import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.TbUserService;
import com.fc.util.FileUploadUtil;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TbUserServiceImpl implements TbUserService {

    @Autowired
    TbUserMapper tbUserMapper;

    @Override
    public ModelAndView login(HttpServletRequest request,HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        TbUserExample tbUserExample = new TbUserExample();

        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andUsernameEqualTo(username).andPasswordEqualTo(password);

        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);

        if (tbUsers.isEmpty()) {
            Map<String, Object> map = new HashMap<>();
            map.put("username",username);
            map.put("password",password);
            ResultInfo resultInfo = new ResultInfo("登录失败，用户名或密码错误", 200, false, map);

            modelAndView.addObject(resultInfo);

            modelAndView.setViewName("/login.jsp");

        }else {
            HttpSession session = request.getSession(true);

            TbUser user = tbUsers.get(0);

            session.setAttribute("user", user);

            Cookie cookie = new Cookie("JSESSIONID",session.getId());

            if (remember != null){
                cookie.setMaxAge(30 * 60 * 1000);
            }else {
                cookie.setMaxAge(0);
            }


            response.addCookie(cookie);

            modelAndView.setViewName("/index/page");

        }
        return modelAndView;
    }

    @Override
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();

        HttpSession session = request.getSession(false);

        session.removeAttribute("user");

        Cookie cookie = new Cookie("JSESSIONID", "");

        cookie.setMaxAge(0);

        response.addCookie(cookie);

        modelAndView.setViewName("redirect:/login.jsp");


        return modelAndView;
    }

    @Override
    public ModelAndView userCenter(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        TbUser user = (TbUser) session.getAttribute("user");

        System.out.println(user);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("menu_page",user);
        modelAndView.addObject("changePage","/user/info.jsp");

        modelAndView.setViewName("/index.jsp");

        return modelAndView;
    }

    @Override
    public ModelAndView update(MultipartFile img, HttpServletRequest request) {

        String nick = request.getParameter("nick");
        String mood = request.getParameter("mood");

        String fileName = null;

        if (!img.isEmpty()) {
            fileName = FileUploadUtil.fileUpload(img);
        }

        HttpSession session = request.getSession(false);

        TbUser user1 = (TbUser) session.getAttribute("user");
        TbUser user = new TbUser();
        user.setId(user1.getId());
        user.setHead(fileName);
        user.setNick(nick);
        user.setMood(mood);

        int rows = tbUserMapper.updateByPrimaryKeySelective(user);

        if (rows > 0) {
            TbUser updatedUser = tbUserMapper.selectByPrimaryKey(user1.getId());

            session.setAttribute("user", updatedUser);
        }

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("/user/userCenter");

        return modelAndView;
    }

    @Override
    public Map<String, Object> checkNick(String checkNick) {

        Integer count = tbUserMapper.selectByNick(checkNick);

        Map<String, Object> map = new HashMap<>();

        if (count > 0) {
            map.put("code", 0);
        }else {
            map.put("code", 1);
        }

        return map;
    }

}
