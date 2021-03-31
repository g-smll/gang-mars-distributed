package com.gang.mars.mq;

import com.gang.mars.mq.service.OrderMqProduceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gang.chen
 * @description
 * @time 2021/3/31 9:22
 */
@SpringBootTest
public class MqTesting {

    @Autowired
    private OrderMqProduceService orderMqService;

    @Test
    void sendMessage(){
        orderMqService.mockOrder();
    }
}
