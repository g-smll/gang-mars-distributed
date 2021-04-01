package com.gang.mars.mq.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author gang.chen
 * @description 短信消息消费
 * @time 2021/3/31 13:31
 */
@Service
@RabbitListener(queues = {"smg.fanout.queue"})
public class ShortMessageMqConsumerService {

    @RabbitHandler
    public void receivedShortMessage(String message){
        System.out.println("short message data -> "+ message);
    }
}
