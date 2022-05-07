package com.fc.service;

import com.fc.vo.ResultInfo;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface TbUserService {
    ModelAndView login(HttpServletRequest request, HttpServletResponse response);

    ModelAndView logout(HttpServletRequest request, HttpServletResponse response);

    ModelAndView userCenter(HttpServletRequest request);

    ModelAndView update(MultipartFile img, HttpServletRequest request);

    Map<String, Object> checkNick(String checkNick);

}
