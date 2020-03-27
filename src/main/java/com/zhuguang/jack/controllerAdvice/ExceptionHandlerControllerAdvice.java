package com.zhuguang.jack.controllerAdvice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* 全局拦截异常的
* */
@ControllerAdvice("com.zhuguang.jack")
public class ExceptionHandlerControllerAdvice {

    /*
    * 把异常进行一个友好返回
    * */
    @ExceptionHandler({ArrayIndexOutOfBoundsException.class})
    public String handlerArrayIndexOutOfBoundsException(Exception e) {
        System.out.println("===========ExceptionHandlerControllerAdvice-->" + e.getMessage());
        return "handlerArrayIndexOutOfBoundsException";
    }

    @ExceptionHandler({NullPointerException.class})
    public @ResponseBody
    String handlerNullPointerException(Exception e) {
        System.out.println("===========ExceptionHandlerControllerAdvice-->" + e.getMessage());
        return "handlerNullPointerException";
    }

}
