package com.fc.controller;

import com.fc.util.JwtUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("User")
public class UserLoginController {

    @RequestMapping("login")
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> result = new HashMap<>();

        Map<String, Object> claim = new HashMap<>();
        if (username.equals("易烊千玺") && password.equals("123456")) {

            String token = JwtUtil.getToken(claim, "qwertyui");

            result.put("token", token);
            result.put("code", 200);
            result.put("success", true);
        } else {
            result.put("code", 404);
            result.put("success", false);
        }

        return result;
    }

    @RequestMapping("verifyToken")
    public Map<String, Object> verify(String token) {
        return JwtUtil.verify(token,"qwertyui");
    }
}
