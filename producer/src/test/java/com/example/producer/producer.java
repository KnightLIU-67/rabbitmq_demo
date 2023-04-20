package com.example.producer;

import com.example.producer.bean.AirMsg;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class producer {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void testMsg(){
        List<Integer> results = new ArrayList<>();
        results.add(1);
        results.add(2);
        AirMsg airMsg = new AirMsg();
        airMsg.setNum(0);
        airMsg.setResults(results);
        airMsg.setDevId("devid");
        rabbitTemplate.convertAndSend("Modbus4jPEXUtils_upsBatchRead","routingKey",airMsg);
    }
}
