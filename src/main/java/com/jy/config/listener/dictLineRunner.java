package com.jy.config.listener;

import com.jy.config.Thread.linkThread;
import com.jy.entity.link;
import com.jy.service.dictCache;
import com.jy.service.dictService;
import com.jy.service.linkService;
import com.jy.util.reloadSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * springBoot启动时加载类，可以用于springboot启动时 加载一些数据
 */
@Component
@Order(value = 1)
//Springboot 启动时 优先级
class dictLineRunner implements CommandLineRunner {
    @Resource
    public reloadSource source;

    @Override
        public void run(String... args) throws Exception {
            System.out.println("-----------加载数据字典---------");

            source.reloadNamesAndLink();


        System.out.println("----------数据字典加载完成--------------");
    }
}
