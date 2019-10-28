package com.jy.controller;
import com.jy.result.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用于处理参数校验错误
     * @Validated校验失败时会抛出MethodArgumentNotValidException异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result methodArgumentValidExceptionHandler(MethodArgumentNotValidException e) throws Exception {
        String code = "200001";
        int status=200;
        String message = null;
//        //如果抛出了异常，这个getErrorCount一定会>0
//        if (e.getBindingResult().getErrorCount() > 0) {
//            //校验会把所有不通过的选项的错误信息记录下来，现在先默认给前端提供第一个错误信息
//            message = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
//        }
        return new Result(status,message);
    }

    //...其他捕获全局异常的代码

}