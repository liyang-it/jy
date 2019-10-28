package com.jy.entity;

import java.util.Date;

public class user {
    private Integer userid;

    private String username;

    private Date createdtime;

    private String srenname;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getSrenname() {
        return srenname;
    }

    public void setSrenname(String srenname) {
        this.srenname = srenname == null ? null : srenname.trim();
    }
}