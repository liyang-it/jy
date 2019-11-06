package com.jy.service;

import com.jy.entity.dict;
import com.jy.entity.link;

import java.util.List;

public class dictCache {
    public static List<dict> dictCacheList;//字典数据
    public static List<link> CacheVedio;
    public static List<link> CacheMusic;
    public static List<link> CacheEpub;
     /*


    public static void getDictCacheList() throws IOException {

        ClassPathResource classPathResource = new ClassPathResource("mapper/dictMapper.xml");//这种形式读取resource文件 打包jar 也可以读取
        InputStream inputStream = classPathResource.getInputStream();

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------
        dictMapper dictMapper = session.getMapper(dictMapper.class);
        List<dict> list = dictMapper.queryDictList();



        dictCacheList=list;
        session.close();

    }
     */
}
