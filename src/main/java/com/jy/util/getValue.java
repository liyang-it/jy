package com.jy.util;

import com.jy.service.dictCache;
import jdk.nashorn.internal.ir.ReturnNode;

import java.util.Random;

/*
获取静态值 与工具值
 */
public class getValue {
    //随机 名字获取
    public  String getRandomName(){

        Random ra=new Random();
        int listSize=dictCache.dictCacheList.size();
        int number=ra.nextInt(listSize);
       return dictCache.dictCacheList.get(number).getValue();
    }
    //文字内容如果有， , 。 . 则换行
    public String getlineContent(String content){
        long startTime=System.currentTimeMillis();//开始时间
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<content.length();i++){
            Character cr=content.charAt(i);
            if(cr.toString().equals(",") || cr.toString().equals("，") || cr.toString().equals(".") || cr.toString().equals("。")){
                //如果包含该字符者插入<br>
                sb.append(cr.toString());
                sb.append("<br>");
            }else{
                sb.append(cr.toString());
            }
        }
        long endTime=System.currentTimeMillis();
        System.out.println("该功能耗时:"+(endTime-startTime)+"ms");
        return sb.toString();
    }
}
