package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by suliguo on 2017/5/17.
 */
@Controller
public class FunctionContoller {
    /**
     * 创建房间(跳转)
     */
    @RequestMapping(value = "room/create", method = RequestMethod.GET)
    public String toCreate() {
        return "";
    }

    /**
     * 创建房间
     */
    @RequestMapping(value = "room/create", method = RequestMethod.POST)
    @ResponseBody
    public String createRoom() {
        return "";
    }

    /**
     * 进入房间
     */
    @RequestMapping(value = "room/{roomId}", method = RequestMethod.GET)
    public String room(@PathVariable String roomId) {
        System.out.println(roomId);
        return "room/publicchat";
    }

    /**
     * 私聊
     */
    @RequestMapping(value = "room/private", method = RequestMethod.GET)
    public String privatechat() {
        return "";
    }

}
