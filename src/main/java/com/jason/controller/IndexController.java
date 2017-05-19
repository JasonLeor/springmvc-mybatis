package com.jason.controller;

import com.jason.jms.activmq.Consumer;
import com.jason.jms.activmq.DemoBean;
import com.jason.service.intf.UserServiceIntf;
import org.apache.activemq.ActiveMQConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by Jason on 2017/3/9
 */
@Controller
public class IndexController {
    @Autowired
    private UserServiceIntf serviceIntf;
    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() throws JMSException {
//        new Date();
//        UserEntity entity = new UserEntity();
//        entity.setAvatar("4");
//        entity.setIsValid((byte) 1);
//        entity.setUserName("jaosnssss");
//        entity.setNickName("heiman");
//        entity.setPassword("546464");
//        entity.setUserId("asdasd854");
//        entity.setLastLoginTime(new Timestamp(System.currentTimeMillis()));
//        entity.setRegisterTime(new Timestamp(System.currentTimeMillis()));
////        entity = serviceIntf.save(entity);
        DemoBean bean = new DemoBean();
        bean.setId(1);
        bean.setMsg("hello");
        jmsTemplate.convertAndSend(bean);
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
