package com.example.producer;

import com.example.producer.config.RabbitmqConfig;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class producer2 {

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
}
