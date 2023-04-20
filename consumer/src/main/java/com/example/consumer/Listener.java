package com.example.consumer;

import com.example.consumer.bean.AirMsg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Listener {
    @RabbitListener(queues = "QueueName")
    @RabbitHandler
    void test(Map message){
        System.out.println("rabbitmq 成功收到消息0");
        System.out.println(message.get("results"));
        System.out.println(message.toString());
    }
}
