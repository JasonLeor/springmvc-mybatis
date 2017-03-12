package com.jason.controller;

import com.jason.dao.HmUserMapper;
import com.jason.model.HmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2017/3/9
 */
@Controller
public class IndexController {
    @Autowired
    private HmUserMapper hmUserMapper;
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        HmUser user = hmUserMapper.selectByPrimaryKey(1);
        System.out.print(user);
        return "hei";
    }
}
