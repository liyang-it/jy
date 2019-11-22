package com.jy.util;

import com.jy.entity.link;
import com.jy.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/*
加载静态资源
 */

public class reloadSource {
    @Autowired
    private dictService service;
    @Autowired
    private linkService linkService;



    public  void reloadNamesAndLink(){
        System.out.println("重载字典数据--->开始");
        dictCache.dictCacheLinkTypeList = service.queryDictByKey("linkType");
        dictCache.dictCacheList = service.queryDictByKey("names");
        for(int i = 0; i < dictCache.dictCacheLinkTypeList.size(); i ++){
            if(dictCache.dictCacheLinkTypeList.get(i).getValue().equals("vedio")){
                dictCache.CacheVedio=linkService.queryLinkByLinkTypeAll(dictCache.dictCacheLinkTypeList.get(i).getValue());
            }

            if(dictCache.dictCacheLinkTypeList.get(i).getValue().equals("music")){
                dictCache.CacheMusic=linkService.queryLinkByLinkTypeAll(dictCache.dictCacheLinkTypeList.get(i).getValue());
            }

            if(dictCache.dictCacheLinkTypeList.get(i).getValue().equals("tools")){
                dictCache.CacheTools=linkService.queryLinkByLinkTypeAll(dictCache.dictCacheLinkTypeList.get(i).getValue());
            }

            if(dictCache.dictCacheLinkTypeList.get(i).getValue().equals("epub")){
                dictCache.CacheEpub=linkService.queryLinkByLinkTypeAll(dictCache.dictCacheLinkTypeList.get(i).getValue());
            }


        }

        System.out.println("重载字典数据--->结束");
    }
}
