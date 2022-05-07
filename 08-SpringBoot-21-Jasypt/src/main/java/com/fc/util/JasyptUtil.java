package com.fc.util;

import org.jasypt.util.text.BasicTextEncryptor;

// 加密工具类
public class JasyptUtil {
    public static void main(String[] args) {
        String username = "root";
        String password = "1020";
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();

        // 密钥
        // 设置盐值
//        basicTextEncryptor.setPassword(System.getProperty("jasypt.basicTextEncryptor.password"));
        basicTextEncryptor.setPassword("qwertyui");

        // 密码进行加密
        String newUsername = basicTextEncryptor.encrypt(username);
        String newPassword = basicTextEncryptor.encrypt(password);

        System.out.println("加密后账号：" + newUsername);
        System.out.println("加密后密码：" + newPassword);
    }
}
