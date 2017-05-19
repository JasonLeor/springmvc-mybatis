package com.jason.jms.activmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by suliguo on 2017/5/19.
 */
@Service
public class Producer {
    @Autowired
    private JmsTemplate jmsTemplate;

}
