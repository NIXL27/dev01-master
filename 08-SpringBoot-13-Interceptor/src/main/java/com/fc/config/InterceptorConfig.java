package com.fc.config;

import com.fc.interceptor.CustomInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 将拦截器注入到容器中
        registry.addInterceptor(new CustomInterceptor()).order(-1).addPathPatterns("/**").excludePathPatterns("/index.html");
    }
}
