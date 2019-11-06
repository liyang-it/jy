package com.jy.config.Thread;

import com.jy.entity.link;
import com.jy.service.dictCache;


import java.util.List;

public class linkThread extends Thread {
    public List<link> list;
    public linkThread(List<link> list){
        this.list=list;
    }
    @Override
    public void run() {
        for (link lk:this.list) {
            if(lk.getLinkType().equals("vedio")){
                dictCache.CacheVedio.add(lk);
            }else if(lk.getLinkType().equals("music")){
                dictCache.CacheMusic.add(lk);
            }else if(lk.getLinkType().equals("epub")){
                dictCache.CacheEpub.add(lk);
            }else {

            }
        }

    }
}
