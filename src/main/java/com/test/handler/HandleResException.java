package com.test.handler;

import com.test.vo.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class HandleResException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result doException() {
        return Result.error(-9999, "服务异常，请稍后再试！");
    }
}
