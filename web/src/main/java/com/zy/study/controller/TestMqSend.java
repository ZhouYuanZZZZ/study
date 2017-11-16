package com.zy.study.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMqSend {

    @Resource
    private JmsTemplate jmsTemplate;

    @Test
    public void test0() {
        Map<String,String> map = new HashMap<>();

        map.put("A","a");
        map.put("B","b");
        map.put("C","c");


        System.out.println("send start");
        //jmsTemplate.send("aaa",messageCreator);
        jmsTemplate.convertAndSend("aaa",map);
        System.out.println("send start");

    }
}
