package com.jy.controller;

import com.jy.entity.link;
import com.jy.entity.wordText;
import com.jy.result.Result;
import com.jy.result.bindResultError;
import com.jy.service.dictCache;
import com.jy.service.wordTextService;
import com.jy.util.getValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jy.config.Validated.*;

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
    @Autowired
    private wordTextService textService;
    public getValue getValue=new getValue();

    @RequestMapping(value = "/queryList.html")
    @ResponseBody
    public List<wordText> queryList(wordText wd){
        wd.setPage((wd.getPage()-1)*wd.getRows());
       // wd.setRows();
      List<wordText> list=  textService.queryWordtextPage(wd);
      return list;

    }
    @RequestMapping(value = "/queryListCount.json")
    @ResponseBody
    public int queryListCount(){

        return textService.getRowsCount();
    }
    @RequestMapping(value ="/getRandomName.json")
    @ResponseBody
    public String getRandomName(){
        return getValue.getRandomName();
    }
    @RequestMapping(value ="/insertWordText.json",method = RequestMethod.POST)
    @ResponseBody
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
        map.put("tools", dictCache.CacheEpub);
        return map;
    }
}
