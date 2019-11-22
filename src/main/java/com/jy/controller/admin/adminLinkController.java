package com.jy.controller.admin;

import com.jy.controller.baseController;
import com.jy.entity.dict;
import com.jy.entity.link;
import com.jy.result.Result;
import com.jy.service.linkService;
import com.jy.util.reloadSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
后台 链接控制器
 */
@RestController
@RequestMapping(value ="/adminLink")
public class adminLinkController extends baseController<link> {
    @Autowired
    private linkService service;
    @Autowired
    private reloadSource loadSource;

    @RequestMapping("/selectLinkByType.json")
    @ResponseBody
    @CrossOrigin
    public Map<String,Object> selectLinkByType(link link){
        List<link> list=null;
        Map<String,Object> map=new HashMap<String,Object>();
        if(link.getLinkType() == null  || link.getLinkType().equals("全部" )){
            list=service.queryLinkByLinkType(link);
        }else{
            list=service.queryLinkByLinkType(link);
        }
        int count=service.selectLinkCount();
        map.put("code",0);
        map.put("count",count);
        map.put("data",list);
        return map;
    }

    @RequestMapping("/selectLinkById.json")
    @ResponseBody
    @CrossOrigin
    public Result selectLinkById(Integer id){

        if(id == null ){
            return errorResult("id不能为空");
        }

        return successResult("获取成功",true,service.selectLinkById(id));
    }

    @RequestMapping("/deleteLinkById.json")
    @ResponseBody
    @CrossOrigin
    public Result deleteLinkById(Integer id){

        if(id == null ){
           return errorResult("id不能为空");
        }
        int success=service.deleteLinkById(id);
        loadSource.reloadNamesAndLink();
       return successResult("删除成功");
    }
    @RequestMapping("/updateLink.json")
    @ResponseBody
    @CrossOrigin
    public Result updateLink(link link){

        service.updateLink(link);

        return successResult("修改成功");
    }
}
