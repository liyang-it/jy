package com.jy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
页面跳转控制器
 */
@Controller
public class pageController {
    @RequestMapping(value = "/")
    public String index(){

        return "index";
    }

    @RequestMapping(value = "index.html")
    public String index1(){
        return "index";
    }
    @RequestMapping(value = "jy/index.html")
    public String jyIndex(){
        return "jy/index";
    }

    @RequestMapping(value = "400.html")
    public String e_400(){
        return "error/400";
    }
    @RequestMapping(value = "404.html")
    public String e_404(){
        return "error/404";
    }
    @RequestMapping(value = "405.html")
    public String e_405(){
        return "error/405";
    }
    @RequestMapping(value = "500.html")
    public String e_500(){
        return "error/500";
    }

    @RequestMapping(value = "/addWordText.html")
    public String addWordText(){
        return "jy/addWordText";
    }






}
