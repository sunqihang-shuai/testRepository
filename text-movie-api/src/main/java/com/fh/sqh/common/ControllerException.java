package com.fh.sqh.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

//SpringMVC的全局异常处理
@ControllerAdvice
public class ControllerException {



    /**
     * 处理所有不可知异常
     *
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public JsonData handleException(Exception e) {
        System.out.println(e.getMessage());
        return JsonData.getJsonError(e.getMessage());
    }
}
