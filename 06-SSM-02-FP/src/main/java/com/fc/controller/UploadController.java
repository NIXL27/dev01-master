package com.fc.controller;

import com.fc.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @RequestMapping("uploadImg")
    public Map<String, Object> testCrossDomainUpload(MultipartFile file) {
        return uploadService.upload(file);
    }
}
