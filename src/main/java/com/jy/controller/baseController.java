package com.jy.controller;

import com.jy.result.Result;
import com.jy.result.bindResultError;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

public class baseController<T> {



    public bindResultError checkBindResult(BindingResult result) {
        StringBuilder sb = new StringBuilder(256);
        bindResultError br=new bindResultError(false,null);
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                sb.append(error.getDefaultMessage());
            }
            br=new bindResultError(true,sb.toString());
        }
        return br;
    }
    public Result errorResult(String message){
        return new Result(400,message);
    }
    public Result successResult(String message){
        return new Result(200,message);
    }
    public Result successResult(String message,boolean success,Object data){
        return new Result(200,message,success,data);
    }
}
