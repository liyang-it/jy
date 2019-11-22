package com.jy.entity;
/*
所有实体的父类
 */
public class baseEntity {
    public int page=1;
    public int limit=15;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = (page-1)*this.limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
