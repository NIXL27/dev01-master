package com.fc.advice;


import com.fc.vo.ResultVO;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 对指定的异常进行捕获
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public ResultVO handleDuplicateKeyException(DuplicateKeyException e) {
        return new ResultVO("该数据已存在", 4000, false, e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultVO handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResultVO("请求参数类型异常", 5000, false, e.getMessage());
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResultVO handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        return new ResultVO("请求参数缺失异常", 6000, false, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVO handleRuntimeException(RuntimeException e) {
        e.printStackTrace();
        return new ResultVO("用户输入异常", 7000, false, e.getMessage());
    }
}
