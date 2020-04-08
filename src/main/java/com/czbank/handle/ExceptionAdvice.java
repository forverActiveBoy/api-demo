package com.czbank.handle;

import com.czbank.entity.ApiException;
import com.czbank.entity.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @author foreverActiveBoy
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdvice {

    /**
     *处理服务器异常
     * @param e 异常对象
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseVO exceptionHandle(Exception e){
        return new ResponseVO(500,"服务器错误！","服务器端错误！");
    }

    /**
     * 处理参数校验异常
     * @param e 方法参数异常异常对象
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseVO exceptionHandle(MethodArgumentNotValidException e){
        log.error("参数校验错误！错误信息：[{}]",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return new ResponseVO(400,"参数校验错误！",e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 处理自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ApiException.class})
    public ResponseVO exceptionHandle(ApiException e){
        log.error("自定义异常错误！错误信息：[{}]",e.getMsg());
        return new ResponseVO(e.getCode(),"自定义异常错误！",e.getMsg());
    }
}
