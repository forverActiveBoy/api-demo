package com.czbank.entity;

import lombok.Getter;

/**
 * @author foreverActiveBoy
 * 自定义参数异常统一返回体
 */
@Getter
public class ApiException extends RuntimeException{
    private int code;
    private String msg;

    public ApiException() {
        this(500, "服务端错误！");
    }

    public ApiException(String msg) {
        this(500, msg);
    }

    public ApiException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
