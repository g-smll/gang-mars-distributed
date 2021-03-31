package com.gang.mars.mq;

import com.gang.mars.mq.service.OrderMqService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gang.chen
 * @description
 * @time 2021/3/31 9:22
 */
@SpringBootTest
public class MqTesting {

    private OrderMqService orderMqService;

    @Test
    void sendMessage(){
        System.out.println("send message...");
    }
}
