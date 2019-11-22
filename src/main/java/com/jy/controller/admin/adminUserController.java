package com.jy.controller.admin;

import com.jy.controller.baseController;
import com.jy.entity.user;
import com.jy.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value ="/adminUser")
public class adminUserController extends baseController<user> {
    @Autowired
    private userService service;

    @RequestMapping(value = "/getUser.json")
    @ResponseBody
    public Map<String,Object> getUser(user u, BindingResult bind){
        user user= service.queryUserByNameAndPasswd(u);
        Map<String,Object> map=new HashMap<>();
        if(user==null){
            map.put("status",false);
        }else{
            map.put("status",true);
            map.put("data",user);
        }
        return map;
    }

}
