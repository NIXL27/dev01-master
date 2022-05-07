package com.fc.filter;

import javax.servlet.*;
import java.io.IOException;

//@WebFilter("/*")
//@Component
// 指定注入到容器中的顺序，数值越大，优先级越低
//@Order(1)
public class RichFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤前：只要有钱");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("过滤后：很有钱");
    }
}
