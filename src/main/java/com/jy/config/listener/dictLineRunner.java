package com.jy.config.listener;

import com.jy.config.Thread.linkThread;
import com.jy.entity.link;
import com.jy.service.dictCache;
import com.jy.service.dictService;
import com.jy.service.linkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Order(value = 1)
//Springboot 启动时 优先级
class dictLineRunner implements CommandLineRunner {
    @Autowired
    private dictService service;
    @Autowired
    private linkService linkService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------加载数据字典---------");

        dictCache.CacheVedio=linkService.queryLinkByLinkType("vedio");
        dictCache.CacheMusic=linkService.queryLinkByLinkType("music");
        dictCache.CacheEpub=linkService.queryLinkByLinkType("epub");
        dictCache.CacheTools=linkService.queryLinkByLinkType("tools");

        dictCache.dictCacheList = service.queryDict();


        System.out.println("----------数据字典加载完成--------------");
    }
}
