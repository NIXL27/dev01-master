package com.fc.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileUploadUtil {
    public static String fileUpload(MultipartFile file) {
        // 准备文件上传的路径
        String path = "http://localhost:8081/upload/";

        File files = new File(path);

        if (!files.exists()) {
            files.mkdirs();
        }

        // 获取文件名
        String filename = file.getOriginalFilename();

        // 获取文件名的后缀名
        filename = filename.substring(filename.indexOf('.'));

        // 声明时间格式
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");

        // 获取当前时间的格式
        String format = dateFormat.format(new Date());

        // 拼接到文件名上
        filename = format + filename;

        // 创建客户端对象
        Client client = Client.create();

        // 连接到图片服务器
        WebResource resource = client.resource(path + filename);

        try {
            // 上传文件
            resource.put(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path + filename;
    }
}
