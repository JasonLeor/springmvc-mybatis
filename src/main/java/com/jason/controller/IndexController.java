package com.jason.controller;

import com.jason.model.UserEntity;
import com.jason.service.intf.UserServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Jason on 2017/3/9
 */
@Controller
public class IndexController {
    @Autowired
    private UserServiceIntf serviceIntf;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        new Date();
        UserEntity entity = new UserEntity();
        entity.setAvatar("4");
        entity.setIsValid((byte) 1);
        entity.setUserName("jaosnssss");
        entity.setNickName("heiman");
        entity.setPassword("546464");
        entity.setUserId("asdasd854");
        entity.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
        entity.setRegisterTime(new Timestamp(System.currentTimeMillis()));
        entity = serviceIntf.save(entity);
        return "index";
    }

//    //
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String index2() {
//        User user = userMapper.selectByPrimaryKey("488");
//        System.out.print(user);
//        return "test";
//    }
}
