package com.czbank.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author foreverActiveBoy
 * 统一返回体
 */
@Getter
@Setter
public class ResponseVO<T> {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 响应信息，用来说明响应情况
     */
    private String msg;
    /**
     * 响应的具体数据
     */
    private T data;


    public ResponseVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 正常返回结果的构造方法
     * @param data
     */
    public ResponseVO(T data) {
        this(200,"success",data);
    }

    /**
     * 异常返回结果用的构造方法
     * @param code
     * @param msg
     */
    public ResponseVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
