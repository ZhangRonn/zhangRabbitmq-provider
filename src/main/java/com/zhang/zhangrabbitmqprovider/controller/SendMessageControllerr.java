package com.zhang.zhangrabbitmqprovider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SendMessageControllerr {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/SendMessageControllerr")
    public String SendMessageControllerr() {
        HashMap<String, Object> map = new HashMap<>();
        ArrayList<Object> objects = new ArrayList<>();
        objects.add("我");
        objects.add("是");
        objects.add("无");
        objects.add("敌");
        objects.add("小");
        objects.add("力");
        objects.add("士");
        objects.add("啊！！！");
        String s="我是张大王啊啊啊！！！！！";
        rabbitTemplate.convertAndSend("topicExchange","topicMan",objects);
        rabbitTemplate.convertAndSend("topicExchange","topicWoman",s);


        return "ok";

    }

}
