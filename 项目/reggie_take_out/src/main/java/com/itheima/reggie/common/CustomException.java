package com.itheima.reggie.common;

/**
 * 第三天
 * 自定义业务异常类
 */
public class CustomException extends RuntimeException {
    public CustomException(String message){
        super(message);
    }
}
