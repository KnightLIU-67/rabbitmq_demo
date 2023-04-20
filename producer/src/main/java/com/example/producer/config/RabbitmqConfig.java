package com.example.producer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RabbitmqConfig implements InitializingBean {

    @Resource
    private RabbitTemplate rabbitTemplate;
    public static final String TEST_EN = "TEST_exchangeName";
    public static final String TEST_QN = "TEST_queueName";
    public static final String TEST_RK = "TEST_routingKey";

    /**
     * 声明交换机
     * @return
     */
    @Bean
    public FanoutExchange exchange(){
        return new FanoutExchange(TEST_EN,true,false);
    }

    /**
     * 声明队列
     * @return
     */
    @Bean
    public Queue queue(){
        return new Queue(TEST_QN,true,false,false);
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

    @Override
    public void afterPropertiesSet() {
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
