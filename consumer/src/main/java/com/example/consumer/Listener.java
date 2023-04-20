package com.example.consumer;

import com.example.consumer.bean.AirMsg;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @RabbitListener(queues = "QueueName")
    @RabbitHandler
    void test(AirMsg message){
        System.out.println(message.toString());
    }
}
