package com.jason.controller;

import com.jason.dao.HmUserMapper;
import com.jason.model.HmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jason on 2017/3/9
 */
@Controller
public class IndexController {
    @Autowired
    private HmUserMapper hmUserMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public HmUser index() {
        HmUser user = hmUserMapper.selectByPrimaryKey(1);
        System.out.print(user);
        return user;
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public String index2() {
        HmUser user = hmUserMapper.selectByPrimaryKey(1);
        System.out.print(user);
        return "test";
    }
}
