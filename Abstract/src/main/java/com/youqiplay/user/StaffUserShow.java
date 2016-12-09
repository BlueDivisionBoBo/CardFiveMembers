package com.youqiplay.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

/**
 * Created by zhouyongbo on 2016/12/7.
 */
public class StaffUserShow {
    private int id;
    private String name;//名称
    private String image;//图片
    @JsonIgnore
    private String pp;//密码保护码
    private String phone;//电话号码
    private String account;//帐号
    @JsonIgnore
    private String password;//密码
    @JsonIgnore
    private int level;//角色: 1:超级管理员 2:代理管理员
    @JsonIgnore
    private int safety;//安全设置开关 : 1:开 2:关
    @JsonIgnore
    private Date modifyDate; //修改时间
    @JsonIgnore
    private String modifyUser; //修改用户
    @JsonIgnore
    private Date createDate; //创建日期
    @JsonIgnore
    private String createUser; //创建用户
    @JsonIgnore
    private Character isEnable; //是否可用

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPp() {
        return pp;
    }

    public void setPp(String pp) {
        this.pp = pp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Character getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Character isEnable) {
        this.isEnable = isEnable;
    }

    public int getSafety() {
        return safety;
    }

    public void setSafety(int safety) {
        this.safety = safety;
    }
}
