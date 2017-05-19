package com.jason.jms.activmq;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

/**
 * Created by suliguo on 2017/5/19.
 */
public class MessageConvert implements MessageConverter {

    public Message toMessage(Object o, Session session) throws JMSException, MessageConversionException {
        System.out.println(o);
        return session.createObjectMessage((Serializable) o);
    }

    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
        ObjectMessage objectMessage = (ObjectMessage) message;
        return objectMessage.getObject();
    }
}
