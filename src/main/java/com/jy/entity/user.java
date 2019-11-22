package com.jy.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class user {
    private Integer userid;


    @NotBlank(message = "登录名不能为空")
    private String username;

    private Date createdtime;

    private String srenname;

    private Integer age;

    private String address;

    private String email;

    private Integer userType;

    private String QQ;

    private Date birthday;

    @NotBlank(message = "密码不能为空")
    private String password;

    public user(Integer userid, String username, Date createdtime, String srenname, Integer age, String address, String email, Integer userType, String QQ, Date birthday,String password) {
        this.userid = userid;
        this.username = username;
        this.createdtime = createdtime;
        this.srenname = srenname;
        this.age = age;
        this.address = address;
        this.email = email;
        this.userType = userType;
        this.QQ = QQ;
        this.birthday = birthday;
        this.password=password;
    }

    public user() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

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