package com.seu.magiccamera.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Index;

/**
 * Created by sunyajie on 2018/12/22.
 */
@Entity
public class User {
    @Index(unique = true)
    private String phoneNum;

    private String pwd;

    @Generated(hash = 983160179)
    public User(String phoneNum, String pwd) {
        this.phoneNum = phoneNum;
        this.pwd = pwd;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
