package com.jy.controller;

import com.jy.entity.link;
import com.jy.entity.wordText;
import com.jy.result.Result;
import com.jy.result.bindResultError;

import com.jy.service.dictCache;
import com.jy.service.linkService;
import com.jy.service.wordTextService;
import com.jy.util.getValue;

import com.jy.util.reloadSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
留言控制器
 */
@RestController
@RequestMapping(value = "/wt")
public class wordTextController extends baseController<wordText>{
    @Resource
    private reloadSource reloadSource;
    @Autowired
    private wordTextService textService;

    @Autowired
    private linkService linkService;
    public getValue getValue=new getValue();

    @RequestMapping(value = "/queryList.html")
    @ResponseBody
    public List<wordText> queryList(wordText wt){



      List<wordText> list=  textService.queryWordtextPage(wt);
      return list;

    }
    @RequestMapping(value = "/queryListCount.json")
    @ResponseBody
    public int queryListCount(){

        return textService.getRowsCount();
    }
    @RequestMapping(value ="/getRandomName.json")
    @ResponseBody
    @CrossOrigin
    public String getRandomName(){
        return getValue.getRandomName();
    }
    @RequestMapping(value ="/insertWordText.json",method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public Result insertWordText(@Valid wordText text, BindingResult bind){
        bindResultError br=checkBindResult(bind);

        if(br.isBind()){
            return errorResult(br.getMessage());
        }
        try {
            text.setCreatedtime(new Date());
            text.setOrnotimg(1);
            text.setUserid(null);
            text.setWordcontent(getValue.getlineContent(text.getWordcontent()));
            textService.insertWordText(text);
        }catch (Exception e) {
            return errorResult(e.getMessage());

        }

        return successResult("打卡成功");
    }
    @RequestMapping("/dateTest.json")
    @ResponseBody
    public List<link> dateTest(){
        return dictCache.CacheVedio;
    }

    //获取资源
    @RequestMapping("/getResource.json")
    @ResponseBody
    public Map<String,List<link>> getResource(){
        Map<String,List<link>> map=new HashMap<String,List<link>>();

        map.put("vedio", dictCache.CacheVedio);
        map.put("music", dictCache.CacheMusic);
        map.put("epub", dictCache.CacheEpub);
        map.put("tools", dictCache.CacheTools);
        return map;
    }
    //后台系统获取 简语列表
    @ResponseBody
    @RequestMapping(value ="/adminGetwordText.json")
    @CrossOrigin
    public Map<String,Object> adminGetwordText(int page,Integer limit, HttpServletResponse response){
        Map<String,Object> map=new HashMap<String,Object>();
        wordText word=new wordText();
        word.setPage(page);
        word.setLimit(limit);
        List<wordText> list=textService.queryWordtextPage(word);
        int count=textService.selectWordTextCount();
        map.put("code",0);
        map.put("count",count);
        map.put("data",list);
        return map;
    }
    //后台系统获取
    @ResponseBody
    @RequestMapping(value ="/deletewordTextByid.json")
    @CrossOrigin
    public Result deletewordTextByid(@Valid  Integer wordid){

        if(wordid==null){
            return errorResult("ID不能为空");
        }
        int success= textService.deleteWordTextById(wordid);
        return  successResult("删除成功");
    }

    //后台系统获取 简语详情
    @ResponseBody
    @RequestMapping(value ="/selectWordTextById.json")
    @CrossOrigin
    public Result selectWordTextById(@Valid  Integer wordid){

        if(wordid==null){
            return errorResult("ID不能为空");
        }

        return  successResult("获取成功",true,textService.selectWordTextById(wordid));
    }
    /**
     * 新增 网址
     */
    @ResponseBody
    @RequestMapping( value = "/addResource.json")
    @CrossOrigin
    public Result addResource(@RequestParam String name,@RequestParam String link,@RequestParam String type,@RequestParam String desc){
        link link1 = new link();
        link1.setLinkDescribe(desc);
        link1.setLinkType(type);
        link1.setLinkName(name);
        int index = link.indexOf("http");
        if(index != -1){
            link1.setLinkAddres(link);
        }else{
            link = "http://"+link;
            link1.setLinkAddres(link);

        }

        int i = linkService.insertLink(link1);


        return successResult(i == 1 ? "新增成功！" : "新增失败");

    }

    /**
     * 刷新资源
     */
    @ResponseBody
    @RequestMapping( value = "/reloadResource.json")
    @CrossOrigin
    public Result reloadResource(){
        String message = "刷新成功";
        try {

            reloadSource.reloadNamesAndLink();//重新刷新资源
        }catch (Exception e){
            e.printStackTrace();
            message= "刷新失败！原因:"+e.getMessage();
        }


        return successResult(message);

    }


}
