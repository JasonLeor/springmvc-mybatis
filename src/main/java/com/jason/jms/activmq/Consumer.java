package com.jason.jms.activmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * 手动 获取队列消息
 * Created by suliguo on 2017/5/19.
 */
@Service
public class Consumer {
    @Autowired
    private JmsTemplate jmsTemplate;

    public TextMessage receive(Destination destination) {
        TextMessage tm = (TextMessage) jmsTemplate.receive();
        try {
            System.out.println(destination.toString() + " --" + tm.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
        return tm;
    }
}
