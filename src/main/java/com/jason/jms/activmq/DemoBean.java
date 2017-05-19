package com.jason.jms.activmq;

import java.io.Serializable;

/**
 * Created by suliguo on 2017/5/19.
 */
public class DemoBean implements Serializable {
    private Integer id;
    private String msg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
