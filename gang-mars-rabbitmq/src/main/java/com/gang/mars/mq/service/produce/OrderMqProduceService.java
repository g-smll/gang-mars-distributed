package com.gang.mars.mq.service.produce;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author gang.chen
 * @description
 * @time 2021/3/31 8:39
 */
@Service
public class OrderMqProduceService {
    private final RabbitTemplate rabbitTemplate;

    public OrderMqProduceService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void mockFanoutOrder(){
        String orderId = UUID.randomUUID().toString();
        /**
         * Convert a Java object to an Amqp {@link Message} and send it to a specific exchange
         * with a specific routing key.
         *
         * @param exchange the name of the exchange，交换机
         * @param routingKey the routing key，路由key,queue队列名称
         * @param message a message to send，消息体
         * @throws AmqpException if there is a problem
         */
        //void convertAndSend(String exchange, String routingKey, Object message) throws AmqpException;

        String exchange = "fanout_order_exchange";
        String routingKey = "";
        rabbitTemplate.convertAndSend(exchange,routingKey,orderId);
    }

    public void mockDirectOrder(){
        String orderId = UUID.randomUUID().toString();
        String exchange = "direct_order_exchange";
        String routingKey = "wechat";
        rabbitTemplate.convertAndSend(exchange,routingKey,orderId);
    }
}
