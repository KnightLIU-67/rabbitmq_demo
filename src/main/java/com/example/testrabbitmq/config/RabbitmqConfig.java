package com.example.testrabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {
    private static String exchangeName = "Modbus4jPEXUtils_upsBatchRead";
    private static String queueName = "QueueName";

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange(exchangeName,true,false);
    }

    /**
     * 声明队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(queueName,true,false,false);
    }

    /**
     * 声明绑定关系
     * @param queue
     * @param fanoutExchange
     * @return
     */
    @Bean
    public Binding queueBinding(Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }


}
