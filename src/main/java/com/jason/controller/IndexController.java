package com.jason.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2017/3/9
 */
@RestController
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "hei";
    }
}
