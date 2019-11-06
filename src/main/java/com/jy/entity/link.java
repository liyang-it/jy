package com.jy.entity;

public class link {
    private int id;
    private String linkAddres;
    private String linkType;
    private String linkByname;
    private String linkName;
    private String linkDescribe;

    public link() {
    }

    public link(int id, String linkAddres, String linkType, String linkByname, String linkName, String linkDescribe) {
        this.id = id;
        this.linkAddres = linkAddres;
        this.linkType = linkType;
        this.linkByname = linkByname;
        this.linkName = linkName;
        this.linkDescribe = linkDescribe;
    }

    public String getLinkDescribe() {
        return linkDescribe;
    }

    public void setLinkDescribe(String linkDescribe) {
        this.linkDescribe = linkDescribe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinkAddres() {
        return linkAddres;
    }

    public void setLinkAddres(String linkAddres) {
        this.linkAddres = linkAddres;
    }

    public String getLinkType() {
        return linkType;
    }

    public void setLinkType(String linkType) {
        this.linkType = linkType;
    }

    public String getLinkByname() {
        return linkByname;
    }

    public void setLinkByname(String linkByname) {
        this.linkByname = linkByname;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }
}
