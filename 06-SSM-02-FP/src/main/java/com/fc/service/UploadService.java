package com.fc.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface UploadService {
    Map<String, Object> upload(MultipartFile file);
}
