package com.jason.jms.activmq;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;

/**
 * Created by suliguo on 2017/5/19.
 */
public class ReceiveListener {
    public void receiveMsg(String message) {
        System.out.println(message);
    }

    public void receiveMsg(Object message) {
        System.out.println(JSON.toJSONString(message));
    }
}
