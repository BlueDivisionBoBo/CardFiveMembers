package com.youqiplay.entity;

import com.youqiplay.user.StaffUserShow;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhouyongbo on 2016/12/7.
 */
@Entity
@Table(name="t_staff_user")
public class StaffUser {
    private int id;
    private String name;//名称
    private String image;//图片
    private String pp;//密码保护码
    private String phone;//电话号码
    private String account;//帐号
    private String password;//密码
    private int level;//角色: 1:超级管理员 2:代理管理员
    private int safety;//安全设置开关 : 1:开 2:关
    private int gid;//所属权限组
    private Date modifyDate; //修改时间
    private String modifyUser; //修改用户
    private Date createDate; //创建日期
    private String createUser; //创建用户
    private Character isEnable; //是否可用

    public StaffUser(StaffUserShow staffUserShow) {
        this.setId(staffUserShow.getId());
        this.setName(staffUserShow.getName());
        this.setImage(staffUserShow.getImage());
        this.setPp(staffUserShow.getPp());
        this.setPhone(staffUserShow.getPhone());
        this.setAccount(staffUserShow.getAccount());
        this.setPassword(staffUserShow.getPassword());
        this.setLevel(staffUserShow.getLevel());
        this.setModifyDate(staffUserShow.getModifyDate());
        this.setModifyUser(staffUserShow.getModifyUser());
        this.setCreateUser(staffUserShow.getCreateUser());
        this.setCreateDate(staffUserShow.getCreateDate());
        this.setIsEnable(staffUserShow.getIsEnable());
    }


    public StaffUser() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
