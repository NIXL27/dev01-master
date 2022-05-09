package com.fc.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("thymeleaf")
public class ThymeleafController {
    @RequestMapping("test")
    public String test(Model model) {
        // 设置model
        model.addAttribute("data","Hello Thymeleaf");

        // 直接会跳到templates下的index.html中
        // 只需要写文件名即可，能够自动识别
        return "index";
    }

    @RequestMapping("test1")
    public ModelAndView test1(ModelAndView mv) {
        // 设置model
        mv.addObject("data","ModelAndView Thymeleaf");

        mv.setViewName("index");

        return mv;
    }

    @RequestMapping("test2")
    public String test2 (HttpServletRequest request) {
        request.setAttribute("data","Request Thymeleaf");

        // 注意，不要使用HttpServletRequest进行转发，因为不能被试图解析器识别路径
        return "index";
    }
}
