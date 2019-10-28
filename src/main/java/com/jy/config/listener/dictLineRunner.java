package com.jy.config.listener;

import com.jy.service.dictCache;
import com.jy.service.dictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(value = 1)//Springboot 启动时 优先级
class dictLineRunner implements CommandLineRunner {
    @Autowired
    private dictService service;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------加载数据字典---------");

           dictCache.dictCacheList=service.queryDict();
           System.out.println(dictCache.dictCacheList);


        System.out.println("----------数据字典加载完成--------------");
    }
}
