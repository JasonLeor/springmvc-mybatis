package com.jason.controller;

import com.jason.bean.in.RegisterBean;
import com.sun.istack.internal.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by suliguo on 2017/5/17.
 */
@Controller
public class UserController {
    /**
     * 跳转注册页面
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public String toRegister() {
        return "user/register";
    }

    /**
     * 注册
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public RegisterBean register(RegisterBean dto) {
        return dto;
    }

    /**
     * 跳转登入界面
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String toLogin() {
        return "user/login";
    }

    /**
     * 登入
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@NotNull String userName, @NotNull String password) {
        return userName + password;
    }

    /**
     * 登出
     *
     * @return
     */
    @RequestMapping(value = "loginout", method = RequestMethod.POST)
    public String loginout() {
        return "";
    }

    /**
     * 跳转修改资料
     */
    @RequestMapping(value = "editinfo", method = RequestMethod.GET)
    public String toEdit() {
        return "";
    }

    /**
     * 修改资料
     */
    @RequestMapping(value = "editinfo", method = RequestMethod.PUT)
    @ResponseBody
    public String edit() {
        return "";
    }

}
