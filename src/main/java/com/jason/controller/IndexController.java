package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2017/3/9
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "hei";
    }
}
