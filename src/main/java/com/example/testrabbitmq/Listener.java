package com.example.testrabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @RabbitListener(queues = "QueueName")
    void test(Message message){
        byte[] body = message.getBody();
        System.out.println(new String(body));
    }
}
