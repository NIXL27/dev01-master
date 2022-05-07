package com.fc.controller;

import com.fc.service.TbUserService;
import com.fc.vo.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("user")
public class TbUserController {

    @Autowired
    private TbUserService tbUserService;

    @RequestMapping("login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        return tbUserService.login(request, response);
    }

    @RequestMapping("logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
        return tbUserService.logout(request, response);
    }

    @RequestMapping("userCenter")
    public ModelAndView userCenter(HttpServletRequest request) {
        return tbUserService.userCenter(request);
    }

    @RequestMapping("update")
    public ModelAndView update(@RequestPart("img") MultipartFile img, HttpServletRequest request) {
        return tbUserService.update(img,request);
    }

    @RequestMapping("checkNick")
    public Map<String,Object> checkNick(String checkNick) {
        return tbUserService.checkNick(checkNick);
    }

}
