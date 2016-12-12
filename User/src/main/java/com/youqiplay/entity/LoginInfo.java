package com.youqiplay.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhouyongbo on 2016/12/12.
 */
@Entity
@Table(name="t_login_info")
public class LoginInfo {
    private int id;
    private int uid;
    private Date date;
    private String address;
    private int source;

    public LoginInfo() {
    }

    public LoginInfo(int id, int uid, Date date, String address, int source) {
        this.id = id;
        this.uid = uid;
        this.date = date;
        this.address = address;
        this.source = source;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
