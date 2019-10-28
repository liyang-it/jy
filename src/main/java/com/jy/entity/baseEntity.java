package com.jy.entity;
/*
所有实体的父类
 */
public class baseEntity {
    public int page=1;
    public int rows=6;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

}
