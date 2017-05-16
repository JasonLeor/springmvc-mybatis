package com.jason.bean.in;

/**
 * Created by suliguo on 2017/5/17.
 */

import com.sun.istack.internal.NotNull;

/**
 * 注册参数
 */
public class RegisterBean {
    @NotNull
    private String userName;
    @NotNull
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
