package com.jy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jy.config.Validated.insert;
import com.jy.config.constants.constants;

import javax.validation.constraints.NotBlank;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.jy.config.Validated.*;
public class wordText extends baseEntity{
    private Integer wordid;
    @NotBlank(message = "标题不能为空")
    private String wordtitle;
    @NotBlank(message = "内容不能为空")
    private String wordcontent;

    private Date createdtime;

    private String createdtimeValue;


    private Integer userid;

    private Integer ornotimg;
    @NotBlank(message = "这么可爱的内容不能没有名称")
    private String username;

    public wordText(String wordtitle, String wordcontent, Date createdtime, Integer userid, Integer ornotimg, String username) {
        this.wordtitle = wordtitle;
        this.wordcontent = wordcontent;
        this.createdtime = createdtime;
        this.userid = userid;
        this.ornotimg = ornotimg;
        this.username = username;
    }

    public wordText() {
    }

    @Override
    public String toString() {
        return "wordText{" +
                "wordid=" + wordid +
                ", wordtitle='" + wordtitle + '\'' +
                ", wordcontent='" + wordcontent + '\'' +
                ", createdtime=" + createdtime +
                ", createdtimeValue='" + createdtimeValue + '\'' +
                ", userid=" + userid +
                ", ornotimg=" + ornotimg +
                ", username='" + username + '\'' +
                '}';
    }

    public String getCreatedtimeValue() {
        return createdtimeValue;
    }


    public Integer getWordid() {
        return wordid;
    }

    public void setWordid(Integer wordid) {
        this.wordid = wordid;
    }

    public String getWordtitle() {
        return wordtitle;
    }

    public void setWordtitle(String wordtitle) {
        this.wordtitle = wordtitle == null ? null : wordtitle.trim();
    }

    public String getWordcontent() {
        return wordcontent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setWordcontent(String wordcontent) {
        this.wordcontent = wordcontent == null ? null : wordcontent.trim();
    }
    @JsonFormat(pattern="yyyy年MM月dd日 HH点mm分ss秒",timezone = "GMT+8")
    public Date getCreatedtime() {

        return createdtime;
    }
    @JsonFormat(pattern="yyyy年MM月dd日 HH点mm分ss秒",timezone = "GMT+8")
    public void setCreatedtime(Date createdtime) {
        //SimpleDateFormat yhmd=new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒");
       // this.createdtimeValue= yhmd.format(createdtime);
        this.createdtime = createdtime;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getOrnotimg() {
        return ornotimg;
    }

    public void setOrnotimg(Integer ornotimg) {
        this.ornotimg = ornotimg;
    }
}