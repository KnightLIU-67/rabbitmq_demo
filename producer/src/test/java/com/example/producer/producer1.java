package com.example.producer;

import com.example.producer.config.RabbitmqConfig;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class producer1 {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testA(){
        Map<String, Object> map = new HashMap<>();
        List<Integer> results = new LinkedList<>();
        results.add(101);
        map.put("results",results);
        map.put("num",1);
        map.put("id","get id");
        System.out.println(map);
        rabbitTemplate.convertAndSend(RabbitmqConfig.TEST_EN, RabbitmqConfig.TEST_RK,map);
        System.out.println("测试 testA 发送消息成功1");
    }

    @RabbitListener(queues = RabbitmqConfig.TEST_QN)
    @RabbitHandler
    void testB(Map message){
        System.out.println("rabbitmq 成功收到消息1");
        System.out.println(message.get("id"));
        testC(message.get("results"));
    }

    void testC(Object obj){
        System.out.println("rabbitmq 成功收到消息2");
        System.out.println(obj.toString());
    }
}
