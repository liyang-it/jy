package com.jy.controller.admin;

import com.jy.controller.baseController;
import com.jy.entity.*;
import com.jy.result.Result;
import com.jy.service.dictCache;
import com.jy.service.dictService;
import com.jy.util.reloadSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
admin后台 字典控制器
 */
@RestController
@RequestMapping(value ="/adminDict")
public class adminDictController extends baseController<dict> {
    @Autowired
    private dictService service;
    @Autowired
    public reloadSource source;

    //后台系统新增 网名
    @ResponseBody
    @RequestMapping(value = "/insertNames.json",method = RequestMethod.GET)
    @CrossOrigin
    public Result insertNames(String value){

        if(value.isEmpty()){
            return errorResult("网名不能为空");
        }
       int success= service.insertNames(value);
        source.reloadNamesAndLink();
        return successResult("新增网名成功");

    }

    //后台系统新增 链接类型
    @ResponseBody
    @RequestMapping(value = "/insertLinkType.json",method = RequestMethod.GET)
    @CrossOrigin
    public Result insertLinkType(String value){

        if(value.isEmpty()){
            return errorResult("链接类型不能为空");
        }
        int success= service.insertLinkType(value);
        source.reloadNamesAndLink();
        return successResult("新增链接类型成功");

    }
    //
    //后台系统获取 网名列表
    @ResponseBody
    @RequestMapping(value ="/adminGetNames.json")
    @CrossOrigin
    public Map<String,Object> adminGetwordText(){
        Map<String,Object> map=new HashMap<String,Object>();
        List<dict> list= dictCache.dictCacheList;
        int count=list.size();
        map.put("code",0);
        map.put("count",count);
        map.put("data",list);
        return map;
    }
    //后台系统删除 简语
    @ResponseBody
    @RequestMapping(value = "/deleteDictById.json",method = RequestMethod.GET)
    @CrossOrigin
    public Result deleteDictById(Integer id){

        if(id == null ){
            return errorResult("id不能为空");
        }
        int success= service.deleteDictById(id);
        source.reloadNamesAndLink();
        return successResult("操作成功");

    }

    //
    //后台系统获取 链接
    @ResponseBody
    @RequestMapping(value ="/adminGetLinkType.json",method = RequestMethod.GET)
    @CrossOrigin
    public Result adminGetLinkType(){

     return successResult("获取成功",true, dictCache.dictCacheLinkTypeList);
    }

}
