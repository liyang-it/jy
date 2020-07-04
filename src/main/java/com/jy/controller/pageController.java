package com.jy.controller;

import com.jy.service.dictCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/resourceHtml.html")
    public String resourceHtml(){
        return "jy/resourceHtml";
    }

    @RequestMapping(value = "/resource.html")
    public String coPyresourceHtml(){
        return "jy/coPyresourceHtml";
    }

    @RequestMapping(value = "/1")
    public String coPyresourceHtml1(){
        return "jy/1";
    }

    @RequestMapping(value = "/form")
    public String formTest(){
        return "jy/formTest";
    }







}
